package com.airbus.codechallenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AuthorizationFailException extends RuntimeException{
	
	public AuthorizationFailException(String message) {
		super(message);
	}

}
