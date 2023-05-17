package com.app.tvshowtracker.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.app.tvshowtracker.dto.AuthRequest;
import com.app.tvshowtracker.dto.AuthResponse;

public class AuthenticationServiceTest {
	
	private AuthenticationService authService;
	
	@BeforeEach
	public void setup() {
		authService = new AuthenticationService();
	}
	
	@Nested
	class LoginTest {
		
		@Test
		public void should_ReturnDoesNotExist_When_UserNotRegistered() {
			//given
			AuthRequest authReq = new AuthRequest("HD206", "solo.123");
			
			//when
			AuthResponse authRes = authService.userLogin(authReq);
			
			//then
			assertAll(
					() -> assertTrue(authRes.getJwtToken().isEmpty()),
					() -> assertEquals("HD206", authRes.getUserid()),
					() -> assertEquals("Failed - User does not exist", authRes.getStatus()));
		}
		
		@Test
		public void should_ReturnTrue_When_CredentialsAreValid() {
			//given
			AuthRequest authReq = new AuthRequest("solo", "solo.123");
			
			//when
			AuthResponse authRes = authService.userLogin(authReq);
			
			//then
			assertAll(
					() -> assertTrue(authRes.getJwtToken().length() > 1),
					() -> assertEquals("solo", authRes.getUserid()),
					() -> assertEquals("Succesfull", authRes.getStatus())
			);
		}
		
		@Test
		public void should_ReturnInvalid_When_UserIdInvalid() {
			//given
			AuthRequest authReq = new AuthRequest("solp", "solo.123");
			
			//when
			AuthResponse authRes = authService.userLogin(authReq);
			
			//then
			assertAll(
					() -> assertTrue(authRes.getJwtToken().isEmpty()),
					() -> assertEquals("solp", authRes.getUserid()),
					() -> assertEquals("Failed - Invalid Credentials", authRes.getStatus()));	
		}
		
		@Test
		public void should_ReturnInvalid_When_PasswordInvalid() {
			//given
			AuthRequest authReq = new AuthRequest("solo", "solo1");
			
			//when
			AuthResponse authRes = authService.userLogin(authReq);
			
			//then
			assertAll(
					() -> assertTrue(authRes.getJwtToken().isEmpty()),
					() -> assertEquals("solo", authRes.getUserid()),
					() -> assertEquals("Failed - Invalid Credentials", authRes.getStatus()));
			
		}
	}
	
	

}
