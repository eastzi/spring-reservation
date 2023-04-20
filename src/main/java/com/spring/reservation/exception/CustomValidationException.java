package com.spring.reservation.exception;

import java.util.Map;

import lombok.Getter;

@Getter
public class CustomValidationException extends RuntimeException {
	
	//getter 대상
	private Map<String, String> errorMap;
	
	public CustomValidationException(String message, Map<String, String> errorMap) {
		super(message); //runtime msg
		this.errorMap = errorMap;
	}
}
