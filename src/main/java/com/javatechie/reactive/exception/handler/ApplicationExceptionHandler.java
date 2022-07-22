package com.javatechie.reactive.exception.handler;

import com.javatechie.reactive.exception.BookAPIException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(BookAPIException.class)
    public ResponseEntity<?> handleBookAPIException(BookAPIException bookAPIException){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error message", bookAPIException.getMessage());
        errorMap.put("status", HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.ok(errorMap);
    }
}


