package com.Flight.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());

    }
    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<String> FlightNotFoundException(FlightNotFoundException e)     {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());}
}
