package com.airbus.codechallenge.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.airbus.codechallenge.constants.ErrorMessage;
import com.airbus.codechallenge.entity.AppUser;
import com.airbus.codechallenge.exception.ResourceAlreadyExistException;
import com.airbus.codechallenge.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public void createUser(AppUser user) {
		AppUser userExist = userRepository.findByUsername(user.getUsername());
		if(!ObjectUtils.isEmpty(userExist)) {
			throw new ResourceAlreadyExistException(ErrorMessage.USER_ALREADY_EXIST + userExist.getUsername());
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}


	/**
	 * custom find user in db 
	 * if found return spring security user details 
	 * else throw user not found exception 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
	}
	
	

}
