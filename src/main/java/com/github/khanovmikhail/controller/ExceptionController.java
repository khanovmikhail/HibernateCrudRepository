package com.github.khanovmikhail.controller;

import com.github.khanovmikhail.model.dto.ErrorInfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public ResponseEntity<ErrorInfoDto> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        ErrorInfoDto errorInfo = new ErrorInfoDto(ex.getClass().getName(), ex.getMessage());

        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorInfoDto> exceptionHandler(Exception ex) {
        ErrorInfoDto errorInfo = new ErrorInfoDto(
                ex.getClass().getName(),
                ex.getMessage()
        );

        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}