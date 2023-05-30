package com.app.tvshowtracker.dto;

public class TvShowSearchReq {
	
	private String tvShowName;
	private Boolean categoryBasedSearch;
	private String genre;
	private String ratings;
	private String language;
	private String actor;
	private String whereToWatch;
	private String releaseDate;
	
	
	public TvShowSearchReq(String tvShowName, Boolean categoryBasedSearch, String genre, String ratings,
			String language, String actor, String whereToWatch, String releaseDate) {
		super();
		this.tvShowName = tvShowName;
		this.categoryBasedSearch = categoryBasedSearch;
		this.genre = genre;
		this.ratings = ratings;
		this.language = language;
		this.actor = actor;
		this.whereToWatch = whereToWatch;
		this.releaseDate = releaseDate;
	}
	public String getTvShowName() {
		return tvShowName;
	}
	public void setTvShowName(String tvShowName) {
		this.tvShowName = tvShowName;
	}
	public Boolean getCategoryBasedSearch() {
		return categoryBasedSearch;
	}
	public void setCategoryBasedSearch(Boolean categoryBasedSearch) {
		this.categoryBasedSearch = categoryBasedSearch;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getWhereToWatch() {
		return whereToWatch;
	}
	public void setWhereToWatch(String whereToWatch) {
		this.whereToWatch = whereToWatch;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
