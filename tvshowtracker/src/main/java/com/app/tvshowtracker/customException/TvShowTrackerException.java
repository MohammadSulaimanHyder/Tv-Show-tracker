package com.app.tvshowtracker.customException;

public class TvShowTrackerException extends RuntimeException {
	
	
	public TvShowTrackerException(String errorMessage)  {
		super(errorMessage);
	}

	public TvShowTrackerException(String exMessage, Exception exception) {
        super(exMessage, exception);
	}

}
