package com.airbus.codechallenge.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	
	private Date timestamp;
	private String httpStatus;
	private String errorDescription;	
	private String errorPath;
	
	
	public ExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ExceptionResponse(Date timestamp, String httpStatus, String errorDescription, String errorPath) {
		super();
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
		this.errorDescription = errorDescription;
		this.errorPath = errorPath;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}	
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getErrorPath() {
		return errorPath;
	}
	public void setErrorPath(String errorPath) {
		this.errorPath = errorPath;
	}		
	
}
