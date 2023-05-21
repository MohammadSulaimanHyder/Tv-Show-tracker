package com.app.tvshowtracker.dto;

public class MovieSrcReq {
	private String movieName;

	public MovieSrcReq(String movieName) {
		super();
		this.movieName = movieName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	
}
