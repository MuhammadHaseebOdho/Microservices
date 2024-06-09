package com.hotel.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import payload.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception){
        ApiResponse apiResponse = ApiResponse.builder().success(true).message(exception.getMessage()).httpStatusCode(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
