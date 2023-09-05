package com.icarlosalbertojr.todomanager.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ExceptionResponse genericExceptionHandler(Exception ex) {
        return ExceptionResponse.builder()
                .message(ex.getMessage())
                .build();
    }

}
