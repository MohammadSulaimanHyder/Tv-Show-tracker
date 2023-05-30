package com.app.tvshowtracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.tvshowtracker.model.TvShow;

public interface TvShowRepository extends JpaRepository<TvShow, Long> {
	
	public Optional<List<TvShow>> findTvShowByName(String tvShowName);
	
	@Query(value = "select * from TvShow where name :=name OR rating =:rating "
			+ "OR releaseDate LIKE :%releaseDate% OR genre =:genre OR language =:language "
			+ "OR actor IN :actor OR whereToWatch IN :whereToWatch", nativeQuery = true)
	public Optional<List<TvShow>> findTvShowBasedOnCatergory(String name, String rating, String releaseDate,
			String genre, String language, String actor, String whereToWatch);

}
