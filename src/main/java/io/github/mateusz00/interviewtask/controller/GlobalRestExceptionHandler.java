package io.github.mateusz00.interviewtask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalRestExceptionHandler {
    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> exceptionHandler() {
        return new ResponseEntity<>("Resource does not exist", HttpStatus.NOT_FOUND);
    }
}