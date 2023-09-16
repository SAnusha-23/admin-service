package com.cg.ims.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	ResponseEntity<String> responseEntity;

    @ExceptionHandler(CategoryException.class)

    public ResponseEntity<String> handleCategoryNotFoundException(Exception e){

        responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);

        return responseEntity;        

    }

}
