package ru.digitallegua.examtask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.digitallegua.examtask.exception.BadModelException;

@RestControllerAdvice
public class ControllerAdviser {

    @ExceptionHandler(value = BadModelException.class)
    public ResponseEntity<String> handle(BadModelException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
