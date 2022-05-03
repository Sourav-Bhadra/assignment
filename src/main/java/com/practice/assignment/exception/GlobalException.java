package com.practice.assignment.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
    @ExceptionHandler(value = HotelIdNotFoundException.class)
    public ResponseEntity<Object> HotelIdNotFoundException(HotelIdNotFoundException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("message", exception.getMessage());
        return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = RoomNumberExceedsException.class)
    public ResponseEntity<Object> RoomNumberExceedsException(RoomNumberExceedsException exception) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("message", exception.getMessage());
        return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
    }
}