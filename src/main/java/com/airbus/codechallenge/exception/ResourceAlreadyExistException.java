package com.airbus.codechallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistException extends RuntimeException{

	public ResourceAlreadyExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
