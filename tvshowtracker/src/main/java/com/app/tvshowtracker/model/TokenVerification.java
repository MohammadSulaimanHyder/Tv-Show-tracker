package com.app.tvshowtracker.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TokenVerification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String token;
	
	@Column(unique = true, nullable = false)
	private String userId;
	
	private Boolean verfied = false;
	private Date createdOn;
	private Date verfiedOn;
	
	
	public TokenVerification() {
		super();
	}
	public TokenVerification(String token, String userId, Date createdOn) {
		super();
		this.token = token;
		this.userId = userId;
		this.createdOn = createdOn;
	}
	public TokenVerification(long id, String token, String userId, Boolean verfied, Date createdOn, Date verfiedOn) {
		super();
		this.id = id;
		this.token = token;
		this.userId = userId;
		this.verfied = verfied;
		this.createdOn = createdOn;
		this.verfiedOn = verfiedOn;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Boolean getVerfied() {
		return verfied;
	}
	public void setVerfied(Boolean verfied) {
		this.verfied = verfied;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getVerfiedOn() {
		return verfiedOn;
	}
	public void setVerfiedOn(Date verfiedOn) {
		this.verfiedOn = verfiedOn;
	}
}
