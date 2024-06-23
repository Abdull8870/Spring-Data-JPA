package com.SpringDataJPA.DataJPA.controllers.global;

import com.SpringDataJPA.DataJPA.exception.EntityNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleResourseNotFoundException(Exception ex){
        ErrorResponse errorResponse=new ErrorResponse(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> error=new ArrayList<>();
        ex.getBindingResult().
                getAllErrors().
                forEach(err->error.add(err.getDefaultMessage()));
        ErrorResponse errorResponse=new ErrorResponse(error);
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);

    }
}
