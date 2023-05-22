package com.app.tvshowtracker.services;


import java.util.HashMap;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import com.app.tvshowtracker.customException.TvShowTrackerException;
import com.app.tvshowtracker.dto.AuthRequest;
import com.app.tvshowtracker.dto.AuthResponse;
import com.app.tvshowtracker.dto.RegRequest;
import com.app.tvshowtracker.dto.RegResponse;
import com.app.tvshowtracker.enums.Roles;
import com.app.tvshowtracker.model.UserDetailsImpl;
import com.app.tvshowtracker.repository.UserDetailsImplRepository;
import com.app.tvshowtracker.securityconfig.JwtUtilService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;



@Service
public class AuthenticationService {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtilService jwtUtilService;
	@Autowired
	private UserDetailsImplRepository userDetailsRepo;
	@Autowired
	MailService mailService;
	@Autowired
	OtpService otpService;
	
	private Predicate<String> pswdInFormat = (password) -> {
		
		Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[.!@#$%&*()_+=|<>?{}\\[\\]~-]");
        
        Matcher hasLetter = letter.matcher(password);
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);
        
        return hasLetter.find() && hasDigit.find() 
        		&& hasSpecial.find() && password.length() >= 8;
	};
	
	public AuthResponse userLogin(AuthRequest authRequest) {
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserId(), authRequest.getPassword()));
		} catch(BadCredentialsException e) {
			new TvShowTrackerException("", e);
			return new AuthResponse(authRequest.getUserId(), "", "Failed - Invalid Credentials");
		}
		
		Optional<UserDetailsImpl> userDetails = userDetailsRepo.findByUserId(authRequest.getUserId());
		
		if(userDetails.isPresent()) {
			String jwtToken = jwtUtilService.generateToken(new HashMap<String, Object>(), userDetails.get());
			
			return new AuthResponse(userDetails.get().getUsername(), jwtToken, "Succesfull");
		} else {
			return new AuthResponse(userDetails.get().getUsername(), "", "Failed - Something went wrong. Please retry later.");
		}
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "{\"status\":\"Succesfull\"}";
	}
	
	@Transactional
	public RegResponse signUp(RegRequest regRequest) {
		
		if(!pswdInFormat.test(regRequest.getPassword())) {
			return new RegResponse("", "Failed - Password is not as per the Policy. Make sure"
					+ "password entered has a Capital, Number and special characters. Length"
					+ "should be atleast 8 characters long.");
		}
		
		UserDetailsImpl userDetails = new UserDetailsImpl();
		
		userDetails.setUserId(regRequest.getUserId());
		userDetails.setPassword(new BCryptPasswordEncoder().encode(regRequest.getPassword()));
		userDetails.setFirstName(regRequest.getFirstName());
		userDetails.setLastName(regRequest.getLastName());
		userDetails.setEmail(regRequest.getEmail());
		userDetails.setRole(Roles.USER);
		
		if(userDetailsRepo.findByUserId(regRequest.getUserId()).isPresent()) {
			return new RegResponse(userDetails.getUsername(), 
					"User - " + regRequest.getUserId() + " already exists. Please try with a diffrent user name.");
		} else {
			userDetailsRepo.save(userDetails);
		}
		
		String token = otpService.generateRegistrationToken(userDetails.getUserId());
		mailService.sendRegistrationMail(userDetails, token);
		
		return new RegResponse(userDetails.getUsername(), "Success - Account has been created. "
				+ "Please check your email for acount verification link.");
	}
	
	public String verifyAccount(String token, String userId) {
		
		return otpService.verifyRegistrationToken(token, userId);
	}

}
