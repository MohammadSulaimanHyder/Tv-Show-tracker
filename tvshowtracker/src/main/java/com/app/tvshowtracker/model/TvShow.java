package com.app.tvshowtracker.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TvShow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String tvShowId;
	
	private String name;
	
	private String rating;
	
	private String poster;
	
	private String duration;
	
	private String releaseDate;
	
	private String description;
	
	private List<String> whereToWatch; 
	
	private List<String> cast;
	
	private List<String> genre;
	
	private String language;
	
	private int noOfAdded;
	
	@OneToMany(mappedBy = "tvShow")
	private List<TvShowSeason> seasons;


	public TvShow(String tvShowId, String name, String rating, String poster, String duration, String releaseDate,
			String description, List<String> whereToWatch, List<String> cast, List<String> genre, String language) {
		super();
		this.tvShowId = tvShowId;
		this.name = name;
		this.rating = rating;
		this.poster = poster;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.description = description;
		this.whereToWatch = whereToWatch;
		this.cast = cast;
		this.genre = genre;
		this.language = language;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTvShowId() {
		return tvShowId;
	}

	public void setTvShowId(String tvShowId) {
		this.tvShowId = tvShowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
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

	public int getNoOfAdded() {
		return noOfAdded;
	}

	public void setNoOfAdded(int noOfAdded) {
		this.noOfAdded = noOfAdded;
	}

	public List<TvShowSeason> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<TvShowSeason> seasons) {
		this.seasons = seasons;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
