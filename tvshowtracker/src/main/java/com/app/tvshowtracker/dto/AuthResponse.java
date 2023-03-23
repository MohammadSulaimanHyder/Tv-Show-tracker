package com.app.tvshowtracker.dto;

public class AuthResponse {
	
	
	private String userid;
	private String jwtToken;
	private String status;
	
	public AuthResponse(String userid, String jwtToken, String status) {
		super();
		this.userid = userid;
		this.jwtToken = jwtToken;
		this.status = status;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
