package com.app.tvshowtracker.services;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.tvshowtracker.model.TokenVerification;
import com.app.tvshowtracker.repository.TokenVerificationRepository;

import jakarta.transaction.Transactional;

public class OtpService {
	
	@Autowired
	TokenVerificationRepository tokenVerifRepo;
	
	@Transactional
	public String generateRegistrationToken(String userId) {
		
		String token = new Random().ints(6, 0, 10).mapToObj(Integer::toString)
			    .reduce((a, b) -> a + b).get();
		
		TokenVerification tokenObj = new TokenVerification(token, userId, new Date());
		
		tokenVerifRepo.save(tokenObj);
		
		return token;
	}
	
	public String verifyRegistrationToken(String token, String userId) {
		
		tokenVerifRepo.updateTokenVerifiedByUserId(new Date(), userId, token);
		
		Optional<TokenVerification> updatedToken = tokenVerifRepo.findByUserId(userId);
		
		if(updatedToken.get().getVerfied()) {
			return "User Account Activated Successfully.";
		} else {
			return "User Account Activation failed. Please try later or contact admin.";
		}
	}

}
