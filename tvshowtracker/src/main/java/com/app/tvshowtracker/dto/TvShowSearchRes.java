package com.app.tvshowtracker.dto;

import java.util.List;

import com.app.tvshowtracker.model.TvShow;

public class TvShowSearchRes {
	
	private List<TvShow> results;
	private String status;
	
	public TvShowSearchRes(List<TvShow> results, String status) {
		super();
		this.results = results;
		this.status = status;
	}
	
	public List<TvShow> getResults() {
		return results;
	}
	public void setResults(List<TvShow> results) {
		this.results = results;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
