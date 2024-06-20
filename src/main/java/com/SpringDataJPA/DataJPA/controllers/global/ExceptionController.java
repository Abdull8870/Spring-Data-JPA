package com.SpringDataJPA.DataJPA.controllers.global;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> catchException(RuntimeException ex){
        return new ResponseEntity<>("Some Internal server error", HttpStatus.BAD_REQUEST);
    }


}
