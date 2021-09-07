package com.dio.sala.de.reuniao.exception;

import java.util.Date;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
}
@ExceptionHandler (ConfigDataResourceNotFoundException.class)
public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
    ErrorDetails errorDetails=new ErrorDetails(new date(), ex.getMessage(), request.get.Description(b: false);
    return new ResponseEntity<>(error.Details, HttpStatus.NOT_FOUND)
}

@ExceptionHandler (Exception.class)
public ResponseEntity<?>globalExceptionHandler(Exception ex, WebRequest request){
    ErrorDetails erroDetails=new ErroDetails(new Date(), ex.getMessage(), request.getDescription(b: false);
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
}