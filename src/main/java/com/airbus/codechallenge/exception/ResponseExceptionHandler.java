package com.airbus.codechallenge.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	/*
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(ObjectNotFoundException ex, WebRequest request){
		ExceptionResponse exception = 
				new ExceptionResponse(new Date(), "404" + HttpStatus.NOT_FOUND, "", "");
		return new ResponseEntity(exception, HttpStatus.NOT_FOUND);
	}
	*/
	
	@ExceptionHandler(AuthenticationFailException.class)
	public ResponseEntity<Object> handleAuthenticationFailException(AuthenticationFailException ex, HttpServletRequest request){
		ExceptionResponse exception = 
				new ExceptionResponse(new Date(), HttpStatus.UNAUTHORIZED.toString(), ex.getMessage(), request.getRequestURI());
		return new ResponseEntity(exception, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(AuthorizationFailException.class)
	public ResponseEntity<Object> handleAuthorizationFailException(AuthorizationFailException ex, HttpServletRequest request){
		ExceptionResponse exception = 
				new ExceptionResponse(new Date(), HttpStatus.FORBIDDEN.toString(), ex.getMessage(), request.getRequestURI());
		return new ResponseEntity(exception, HttpStatus.FORBIDDEN);
	}	
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){
		ExceptionResponse exception = 
				new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.toString(), ex.getMessage(), request.getRequestURI());
		return new ResponseEntity(exception, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ResourceAlreadyExistException.class)
	public ResponseEntity<Object> handleAlreadyExistException(ResourceAlreadyExistException ex, HttpServletRequest request){
		ExceptionResponse exception = 
				new ExceptionResponse(new Date(), HttpStatus.CONFLICT.toString(), ex.getMessage(), request.getRequestURI());
		return new ResponseEntity(exception, HttpStatus.CONFLICT);
	}	
		
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex, HttpServletRequest request){
		ExceptionResponse exception = 
				new ExceptionResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(), request.getRequestURI());
		return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
