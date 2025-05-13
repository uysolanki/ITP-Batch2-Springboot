package com.itp.alibaba.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itp.alibaba.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException ex)
	{
		ErrorResponse error=new ErrorResponse("Product Not Found",ex.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
}
