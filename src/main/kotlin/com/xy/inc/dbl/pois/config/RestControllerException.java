package com.xy.inc.dbl.pois.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestControllerException {


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleError(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> errors = new ArrayList<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(it -> {
            errors.add(it.getDefaultMessage());
        });

        return ResponseEntity.unprocessableEntity().body(errors);
    }

    @ExceptionHandler(value = Exception.class)
    public void handle(Exception e) {
        System.out.println(e.getMessage());
    }
}
