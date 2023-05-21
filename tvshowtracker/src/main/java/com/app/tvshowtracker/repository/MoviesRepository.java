package com.app.tvshowtracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.tvshowtracker.model.Movie;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Long> {

	public Optional<List<Movie>> findByMovieName(String movieName);

}
