package com.ems.departmentservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(RuntimeException exception,
			WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(),
				request.getDescription(false), "DEPARTMENT_NOT_FOUND");

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
