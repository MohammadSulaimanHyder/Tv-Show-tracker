package com.app.tvshowtracker.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.tvshowtracker.dto.AuthRequest;
import com.app.tvshowtracker.dto.AuthResponse;
import com.app.tvshowtracker.dto.LogoutRequest;
import com.app.tvshowtracker.model.UserDetailsImpl;
import com.app.tvshowtracker.repository.UserDetailsImplRepository;
import com.app.tvshowtracker.securityconfig.JwtUtilService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Service
public class AuthenticationService {
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtUtilService jwtUtilService;
	@Autowired
	private UserDetailsImplRepository userDetailsRepo;
	
	public AuthResponse userLogin(AuthRequest authRequest) {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserId(), authRequest.getPassword()));
		
		Optional<UserDetailsImpl> userDetails = userDetailsRepo.findByUserId(authRequest.getUserId());
		
		AuthResponse authResponse = null;
		
		if(userDetails.isPresent()) {
			String jwtToken = jwtUtilService.generateToken(null, userDetails.get());
			
			authResponse = new AuthResponse(jwtToken, userDetails.get().getUsername(), "Succesfull");
		} else {
			authResponse = new AuthResponse("", userDetails.get().getUsername(), "Failed");
		}
		
		return authResponse;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "{\"status\":\"Succesfull\"}";
	}

}
