package com.app.tvshowtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.tvshowtracker.dto.AuthRequest;
import com.app.tvshowtracker.dto.AuthResponse;
import com.app.tvshowtracker.dto.RegRequest;
import com.app.tvshowtracker.dto.RegResponse;
import com.app.tvshowtracker.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/app/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/userlogin")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
		
		AuthResponse authenticatedResponse = authenticationService.userLogin(authRequest);
		return new ResponseEntity<AuthResponse>(authenticatedResponse, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
		
		String status = authenticationService.logout(request, response);
		
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	@PostMapping("/usersignup")
	public ResponseEntity<RegResponse> signUp(@RequestBody RegRequest regRequest) {
		
		RegResponse regResponse = authenticationService.signUp(regRequest);
		
		return new ResponseEntity<RegResponse>(regResponse, HttpStatus.OK);
	}
	
	@GetMapping("/accountVerification/{token}/{userID}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token, @PathVariable String userId) {
		
		String response = authenticationService.verifyAccount(token, userId);
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
