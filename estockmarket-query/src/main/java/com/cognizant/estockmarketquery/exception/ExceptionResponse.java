package com.cognizant.estockmarketquery.exception;

import java.time.LocalDateTime;

import lombok.Data;

public class ExceptionResponse {
	private String message;
    private LocalDateTime dateTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public ExceptionResponse(String message, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.dateTime = dateTime;
	}
	public ExceptionResponse() {
		super();
	}
    
    
}
