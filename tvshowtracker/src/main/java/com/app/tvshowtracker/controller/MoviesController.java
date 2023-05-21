package com.app.tvshowtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.tvshowtracker.dto.MovieSrcReq;
import com.app.tvshowtracker.dto.MovieSrcRes;
import com.app.tvshowtracker.services.MovieService;

@RestController
@RequestMapping("/app/movies")
public class MoviesController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/search")
	public ResponseEntity<MovieSrcRes> movieSearch(@RequestBody MovieSrcReq movieReq) {
		
		MovieSrcRes movieRes = movieService.movieSearch(movieReq);
		return new ResponseEntity<MovieSrcRes>(movieRes, HttpStatus.OK);
	}
}
