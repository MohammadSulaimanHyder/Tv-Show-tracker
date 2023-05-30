package com.app.tvshowtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.tvshowtracker.dto.TvShowSearchReq;
import com.app.tvshowtracker.dto.TvShowSearchRes;
import com.app.tvshowtracker.model.TvShow;
import com.app.tvshowtracker.repository.TvShowRepository;

@Service
public class TvShowService {
	
	@Autowired
	private TvShowRepository tvShowRepo;
	
	public TvShowSearchRes getTvShowSearchResults(TvShowSearchReq req) {
		
		Optional<List<TvShow>> searchResults = tvShowRepo.findTvShowByName(req.getTvShowName());
		
		if(searchResults.isPresent()) {
			return new TvShowSearchRes(searchResults.get(), "Succesfull");
		} else {
			return new TvShowSearchRes(null, "Failed - Search did not yeild any results.");
		}
	}
	
	public TvShowSearchRes getTvShwResultsBasedOnCatagory(TvShowSearchReq req) {
		
		Optional<List<TvShow>> searchResults = tvShowRepo.findTvShowBasedOnCatergory(req.getTvShowName(), 
				req.getRatings(), req.getReleaseDate(), req.getGenre(), req.getLanguage(),
				req.getActor(), req.getWhereToWatch());
		
		if(searchResults.isPresent()) {
			return new TvShowSearchRes(searchResults.get(), "Succesfull");
		} else {
			return new TvShowSearchRes(null, "Failed - Could not find any shows under given category.");	
		}
	}

}
