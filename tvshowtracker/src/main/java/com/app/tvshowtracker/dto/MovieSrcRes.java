package com.app.tvshowtracker.dto;

import java.util.List;

import com.app.tvshowtracker.model.Movie;

public class MovieSrcRes {

	private List<Movie> movieResult;
	private String status;

	public MovieSrcRes(List<Movie> movieResult, String status) {
		super();
		this.movieResult = movieResult;
		this.status = status;
	}
	public MovieSrcRes(List<Movie> movieResult) {
		super();
		this.movieResult = movieResult;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Movie> getMovieResult() {
		return movieResult;
	}

	public void setMovieResult(List<Movie> movieResult) {
		this.movieResult = movieResult;
	}
}
