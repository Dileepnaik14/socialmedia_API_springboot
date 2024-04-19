package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelException {
	@ExceptionHandler(Exception.class)
public ResponseEntity<ErrorDetails> otherExceptionHandler( Exception ue,WebRequest req){
	ErrorDetails errorDetails= new ErrorDetails( ue.getMessage(),req.getDescription(false),LocalDateTime.now());
	return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
}
}
