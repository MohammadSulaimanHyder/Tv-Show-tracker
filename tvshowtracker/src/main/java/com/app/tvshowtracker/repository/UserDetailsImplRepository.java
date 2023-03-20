package com.app.tvshowtracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.tvshowtracker.model.UserDetailsImpl;

@Repository
public interface UserDetailsImplRepository extends JpaRepository<UserDetailsImpl, Long>{
	
	public Optional<UserDetailsImpl> findByUserId();

}
