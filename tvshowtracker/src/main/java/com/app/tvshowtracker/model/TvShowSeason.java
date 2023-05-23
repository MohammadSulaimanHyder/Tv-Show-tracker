package com.app.tvshowtracker.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TvShowSeason {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String poster;
	
	private String releaseDate;
	
	private String description;
	
	@OneToMany(mappedBy = "season")
	private List<TvShowEpisode> episodes;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = TvShow.class)
	@JoinColumn(name = "tvShow", nullable = false)
	private TvShow tvShow;	
	
	public TvShowSeason(String poster, String releaseDate, String description, List<TvShowEpisode> episodes) {
		super();
		this.poster = poster;
		this.releaseDate = releaseDate;
		this.description = description;
		this.episodes = episodes;
	}
	
	public TvShowSeason(String poster, String releaseDate, String description, List<TvShowEpisode> episodes,
			TvShow tvShow) {
		super();
		this.poster = poster;
		this.releaseDate = releaseDate;
		this.description = description;
		this.episodes = episodes;
		this.tvShow = tvShow;
	}



	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
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

	public List<TvShowEpisode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(List<TvShowEpisode> episodes) {
		this.episodes = episodes;
	}

	public TvShow getTvShow() {
		return tvShow;
	}

	public void setTvShow(TvShow tvShow) {
		this.tvShow = tvShow;
	}
}
