package com.avstp.moexservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MoexExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(BondNotFoundException.class)
    public ResponseEntity<ErrorDto> handleBondNotFoundException(BondNotFoundException exception) {
        return new ResponseEntity<>(new ErrorDto(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
