package com.app.tvshowtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.tvshowtracker.dto.MovieSrcReq;
import com.app.tvshowtracker.dto.MovieSrcRes;
import com.app.tvshowtracker.model.Movie;
import com.app.tvshowtracker.repository.MoviesRepository;

public class MovieService {
	
	@Autowired
	private MoviesRepository movieRepository;
	
	public MovieSrcRes movieSearch(MovieSrcReq movieRequest) {
		Optional<List<Movie>> movieResults = movieRepository.findByMovieName(movieRequest.getMovieName());
		
		if(movieResults.isPresent()) {
						
			return new MovieSrcRes(movieResults.get());
		}else {
			return new MovieSrcRes(movieResults.get(),"Failed to find the movie");		
				}
		
		}
}