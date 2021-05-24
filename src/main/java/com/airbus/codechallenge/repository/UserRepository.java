package com.airbus.codechallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airbus.codechallenge.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
	
	AppUser findByUsername(String username);
	
}
