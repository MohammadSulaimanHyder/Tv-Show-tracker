package com.app.tvshowtracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String userId;
	
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "moviePost", nullable = false)
	private MoviePost moviePost;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private TvShowPost tvShowPost;
		

	public Comment() {
		super();
	}


	public Comment(String userId, String comment, MoviePost moviePost) {
		super();
		this.userId = userId;
		this.comment = comment;
		this.moviePost = moviePost;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public MoviePost getPost() {
		return moviePost;
	}


	public void setPost(MoviePost moviePost) {
		this.moviePost = moviePost;
	}
}
