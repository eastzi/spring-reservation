package com.spring.reservation.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.reservation.dto.CMRespDto;
import com.spring.reservation.exception.CustomValidationException;

@RestController
@RestControllerAdvice
public class RestControllerExceptionHandler {

	@ExceptionHandler(CustomValidationException.class)
	public ResponseEntity<?> validationErrorException(CustomValidationException e) {
		
		return ResponseEntity.badRequest().body(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()));
	}
}
