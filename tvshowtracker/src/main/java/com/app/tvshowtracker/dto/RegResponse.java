package com.app.tvshowtracker.dto;

public class RegResponse {
	
	String userId;
	String statusMessage;
	
	public RegResponse(String userId, String statusMessage) {
		super();
		this.userId = userId;
		this.statusMessage = statusMessage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
