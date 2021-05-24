package com.airbus.codechallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airbus.codechallenge.entity.AppUser;
import com.airbus.codechallenge.service.UserService;

@RestController
//@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<AppUser> createUser(@RequestBody AppUser user){
		userService.createUser(user);
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/login")
	public void authenticateUser(@RequestBody AppUser user) {
		
	}

}
