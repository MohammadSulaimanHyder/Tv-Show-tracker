package com.app.tvshowtracker.securityconfig;



import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.tvshowtracker.model.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtilService {
	
	private String SECRET_KEY = "B374A26A71490437AA024E4FADD5B497FDFF1A8EA6FF12F6FB65AF2720B59CCF";
	
	public String extractUserId(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Boolean isTokenValid(String token, UserDetails userDetails) {
		
		String userId = extractUserId(token);
		
		return userId.equalsIgnoreCase(userDetails.getUsername()) && isTokenExpired(token);
	}
	
	public Boolean isTokenExpired(String token) {
		
		return extractClaim(token, Claims::getExpiration)
				.before(new Date(System.currentTimeMillis()));
	}
	
	
	public String generateToken(Map<String, Object> extraClaims, UserDetailsImpl userDetails) {
		
		return Jwts.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
				.signWith(getKey())
				.compact();
	}
	
	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		
		Claims claims = extractClaims(token);
				
		return claimResolver.apply(claims);
	}
	
	private Claims extractClaims(String token) {
		
		return Jwts.parserBuilder().setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
		
	}
	
	private Key getKey() {
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}


}
