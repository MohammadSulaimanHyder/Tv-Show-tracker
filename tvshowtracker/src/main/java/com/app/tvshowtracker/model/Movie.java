package com.app.tvshowtracker.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String movieId;
	
	private String poster;
	
	private String movieName;
	
	private String duration;
	
	private String releaseDate;
	
	private String ratings;
	
	private String description;
	
	private List<String> whereToWatch; 
	
	private List<String> cast; 
	
	//mappedBy here will override the default implementation which will create a third table with movie and posts.
	//With this it states that which ever class is creating the relationship, let them handle the movie and posts.
	//No post column will be added in the movie table.
	@OneToMany(mappedBy = "movie") 
	private List<MoviePost> posts;
	
	private int noOfAdded;
	
	private int noOfWatches;
	
	private int noOfLikes;
	
	private int noOfDislikes;


	public Movie() {
		super();
	}
		
	public Movie(String movieId, String poster, String name, String duration, String releaseDate, String ratings, String description,
			List<String> whereToWatch, List<String> cast) {
		super();
		
		this.movieId = movieId;
		this.poster = poster;
		this.movieName = name;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.ratings = ratings;
		this.description = description;
		this.whereToWatch = whereToWatch;
		this.cast = cast;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getName() {
		return movieName;
	}

	public void setName(String name) {
		this.movieName = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getWhereToWatch() {
		return whereToWatch;
	}

	public void setWhereToWatch(List<String> whereToWatch) {
		this.whereToWatch = whereToWatch;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	public List<MoviePost> getPosts() {
		return posts;
	}

	public void setPosts(List<MoviePost> posts) {
		this.posts = posts;
	}

	public int getNoOfAdded() {
		return noOfAdded;
	}

	public void setNoOfAdded(int noOfAdded) {
		this.noOfAdded = noOfAdded;
	}

	public int getNoOfWatches() {
		return noOfWatches;
	}

	public void setNoOfWatches(int noOfWatches) {
		this.noOfWatches = noOfWatches;
	}

	public int getNoOfLikes() {
		return noOfLikes;
	}

	public void setNoOfLikes(int noOfLikes) {
		this.noOfLikes = noOfLikes;
	}

	public int getNoOfDislikes() {
		return noOfDislikes;
	}

	public void setNoOfDislikes(int noOfDislikes) {
		this.noOfDislikes = noOfDislikes;
	}
}
