package com.dago.gestion_de_stock.exceptions;



import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleException(IllegalStateException exception){
        return ResponseEntity.internalServerError().body(exception.getMessage());

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleException(EntityNotFoundException exception){
       return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EntityNotValidException.class)
    public ResponseEntity<?> handleException(EntityNotValidException exception){
        return ResponseEntity.badRequest().body(exception.getErrorMessages());
    }

    @ExceptionHandler(EntityAlreadyExistException.class)
    public ResponseEntity<?> handleException(EntityAlreadyExistException exception){
        return ResponseEntity.badRequest().body(exception.getErrorMessages());

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentException(MethodArgumentNotValidException exception){
        return ResponseEntity.notFound().build();

    }

}
