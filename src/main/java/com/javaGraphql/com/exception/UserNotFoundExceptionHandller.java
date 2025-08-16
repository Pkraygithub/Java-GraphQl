package com.javaGraphql.com.exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserNotFoundExceptionHandller {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> exceptionHnadller(UserNotFoundException unfe){
		
		
		ErrorDetails error=new ErrorDetails();
		
		error.getLocaltime();
		
		return new ResponseEntity<>(new ErrorDetails(
				unfe.getMessage(), "User Details are Not Available", "User Details", LocalTime.now())
				,HttpStatus.NOT_FOUND);
		
	}
	
}
