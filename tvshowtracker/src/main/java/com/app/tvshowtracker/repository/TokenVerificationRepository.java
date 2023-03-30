package com.app.tvshowtracker.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.tvshowtracker.model.TokenVerification;

import jakarta.transaction.Transactional;

public interface TokenVerificationRepository extends JpaRepository<TokenVerification, Long> {
	
	
	public Optional<TokenVerification> findByUserId(String userId);
	
	
	@Modifying
	@Transactional
	@Query("update TokenVerification set verfied=ture, verfiedOn =:verfiedOn "
			+ "where userId= :userId and token =:token")
	public int updateTokenVerifiedByUserId(Date verfiedOn, String userId, String token);

}
