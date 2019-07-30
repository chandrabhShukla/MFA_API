package com.tgt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handler
 * 
 * @author Chandra Bhan
 */
@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> exception(UserNotFoundException exception) {
		return new ResponseEntity<>(exception.getErrorMessage(), HttpStatus.valueOf(exception.getErrorCode()));
	}

	@ExceptionHandler(value = InvalidInputException.class)
	public ResponseEntity<?> invalidInputExceptionHandlerResponse(InvalidInputException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> invalidExceptionHandlerResponse(Exception ex) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
