package com.app.tvshowtracker.securityconfig;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtilService jwtUtilService;
	@Lazy
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		 String authHeader = request.getHeader("Authorization");
		 
		 //If this condition is true then user is not authenticated.
		 if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			 filterChain.doFilter(request, response);
			 return;
		 }
		 
		 String jwtToken = authHeader.substring(7);
		 String userNameId = jwtUtilService.extractUserId(jwtToken);
		 
		 if(userNameId != null && SecurityContextHolder.getContext().getAuthentication() == null) 
		 {
			 UserDetails userDetails = userDetailsService.loadUserByUsername(userNameId);
			 
			 if(jwtUtilService.isTokenValid(jwtToken, userDetails))
			 {
				 UsernamePasswordAuthenticationToken usernamePasswordAuthToken = new 
							UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
					
					usernamePasswordAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthToken);
			 }
		 }
		 
		 filterChain.doFilter(request, response);
		
		
	}

}
