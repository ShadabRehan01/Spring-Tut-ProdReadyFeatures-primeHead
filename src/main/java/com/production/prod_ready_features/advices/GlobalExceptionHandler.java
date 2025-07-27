package com.production.prod_ready_features.advices;

import com.production.prod_ready_features.exceptions.ResourceNotFoundExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundExceptions exceptions){
        ApiError apiError=new ApiError(exceptions.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
