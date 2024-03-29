package com.app.tvshowtracker.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@Column(nullable = false)
	private String email;

	
	@Column(nullable = false, unique = true)
	private String userId;
	
	
	//List<Movie> watchedMovies;
	
	//List<Movie> moviesToWatch;
	
	//List<Movie> favMovies;

}
