package com.SpringDataJPA.DataJPA.controllers.global;

import com.SpringDataJPA.DataJPA.exception.EntityNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleResourseNotFoundException(Exception ex){
        ErrorResponse errorResponse=new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }



}
