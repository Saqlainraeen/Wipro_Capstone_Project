package com.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String>handleResourceNotFoundException(ResourceNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String>handleGeneralException(Exception ex){
		return new ResponseEntity<>("Hi! Saqlain you got some error:"+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getFieldErrors().forEach(error ->
	            errors.put(error.getField(), error.getDefaultMessage())
	        );
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	        
	    }
	 @ExceptionHandler(InvalidIdException.class)
	    public ResponseEntity<String> handleInvalidIdException(InvalidIdException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

}
