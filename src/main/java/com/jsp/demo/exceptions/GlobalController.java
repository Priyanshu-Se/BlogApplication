package com.jsp.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.demo.dto.ResponseStructure;

import io.swagger.v3.oas.annotations.Hidden;

@RestControllerAdvice
@Hidden
public class GlobalController {

	@ExceptionHandler(value = EntityAlreadyExistsException.class)
	public ResponseEntity<ResponseStructure> handleEntityAlreadyExistsException(EntityAlreadyExistsException e) {
		ResponseStructure<Object> structure = new ResponseStructure<>(HttpStatus.CONFLICT.value(), e.getMessage(), null,
				LocalDateTime.now());
		return new ResponseEntity<ResponseStructure>(structure, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = EntityNotFoundException.class)
	public ResponseEntity<ResponseStructure> handleEntityNotFoundException(EntityNotFoundException e) {
		ResponseStructure<Object> structure = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				null, LocalDateTime.now());
		return new ResponseEntity<ResponseStructure>(structure, HttpStatus.NOT_FOUND);
	}
}
