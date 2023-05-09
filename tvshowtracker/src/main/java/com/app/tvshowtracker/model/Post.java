package com.app.tvshowtracker.model;

import java.util.List;
import java.util.Random;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String postId;
	
	@Column(nullable = false)
	private String userId;
	
	private String body;
	
	private List<String> images;
	
	@OneToMany(mappedBy = "post")
	private List<Comment> comments;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Movie.class)
	@JoinColumn(name = "movieId", nullable = false) // will create a bidirectional relationship with movie.
	private Movie movie; // This will add a movie column in the table.
	
	
	public Post() {
		super();
	}

	public Post(String userId, String body, List<String> images, List<Comment> comments, Movie movie) {
		super();
		this.postId = new Random().ints(4, 0, 10).mapToObj(Integer::toString)
			    .reduce((a, b) -> a + b).get();
		
		this.userId = userId;
		this.body = body;
		this.images = images;
		this.comments = comments;
		this.movie = movie;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
