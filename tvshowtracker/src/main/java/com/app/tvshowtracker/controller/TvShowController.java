package com.app.tvshowtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.tvshowtracker.dto.TvShowSearchReq;
import com.app.tvshowtracker.dto.TvShowSearchRes;
import com.app.tvshowtracker.services.TvShowService;

@Controller
@RequestMapping("/app/tvshows")
public class TvShowController {
	
	@Autowired
	private TvShowService tvShowService;
	
	@PostMapping("/search")
	public ResponseEntity<TvShowSearchRes> getTvShowResults(@RequestBody TvShowSearchReq req) {
		
		TvShowSearchRes searchResult;
		
		if(req.getCategoryBasedSearch()) {
			searchResult = tvShowService.getTvShwResultsBasedOnCatagory(req);
		} else {
			searchResult = tvShowService.getTvShowSearchResults(req);
		}
		
		return new ResponseEntity<TvShowSearchRes>(searchResult, HttpStatus.OK);
	}

}
