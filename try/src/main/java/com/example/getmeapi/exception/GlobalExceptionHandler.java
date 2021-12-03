package com.example.getmeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RestrictedInfoException.class)
    public ResponseEntity< String> restricedError(RestrictedInfoException ex){
        return new ResponseEntity<>("no such ele found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity< String> restricedInfoException(RestrictedInfoException ex){
        return new ResponseEntity<>("no such ele found", HttpStatus.CONFLICT);
    }


}
