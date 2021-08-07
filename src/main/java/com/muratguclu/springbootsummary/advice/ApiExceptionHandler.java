package com.muratguclu.springbootsummary.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    private final ResponseEntity<ExceptionResponse> illegalException (Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"1000",exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(UserNotFound.class)
    private final ResponseEntity<ExceptionResponse> userNotFoundException (Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"1000",exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.EXPECTATION_FAILED);
    }
}
