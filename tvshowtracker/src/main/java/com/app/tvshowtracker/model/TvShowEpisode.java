package com.app.tvshowtracker.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TvShowEpisode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(unique = true, nullable = false)
	private String episodeId;
	
	private String rating;
	
	private String poster;
	
	private String duration;
	
	private String releaseDate;
	
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = TvShowSeason.class)
	@JoinColumn(nullable = false)
	private TvShowSeason season;
	

	public TvShowEpisode(String name, String episodeId, String rating, String poster, String duration,
			String releaseDate, String description, TvShowSeason season) {
		super();
		this.name = name;
		this.episodeId = episodeId;
		this.rating = rating;
		this.poster = poster;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.description = description;
		this.season = season;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
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

	public TvShowSeason getSeason() {
		return season;
	}

	public void setSeason(TvShowSeason season) {
		this.season = season;
	}
}
