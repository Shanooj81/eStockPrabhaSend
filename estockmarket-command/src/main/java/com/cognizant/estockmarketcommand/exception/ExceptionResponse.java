package com.cognizant.estockmarketcommand.exception;

import java.time.LocalDateTime;

import lombok.Data;

public class ExceptionResponse {
	private String message;
	private LocalDateTime dateTime;
	
    public String getMessage() {
		return message;
	}
	public ExceptionResponse() {
		super();
	}
	public ExceptionResponse(String message, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.dateTime = dateTime;
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
	
}
