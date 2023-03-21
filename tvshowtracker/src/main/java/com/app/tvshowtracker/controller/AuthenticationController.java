package com.app.tvshowtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.tvshowtracker.dto.AuthRequest;
import com.app.tvshowtracker.dto.AuthResponse;
import com.app.tvshowtracker.dto.RegRequest;
import com.app.tvshowtracker.dto.RegResponse;
import com.app.tvshowtracker.services.AuthenticationService;

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
	
	
	@PostMapping("/usersignup")
	public ResponseEntity<RegResponse> login(@RequestBody RegRequest regResponse) {
		
		
		return null;
	}
	
	
	

}
