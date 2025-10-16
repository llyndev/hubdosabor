package com.hubdosabor.hubdosabor.config.exception;

import com.hubdosabor.hubdosabor.config.exception.custom.AccessDeniedException;
import com.hubdosabor.hubdosabor.config.exception.custom.ResourceNotFoundException;
import com.hubdosabor.hubdosabor.config.exception.custom.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, String>> handleIllegalState(IllegalStateException exception) {
        Map<String, String> body = Map.of("Error", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException exception) {
        Map<String, String> body = Map.of("Error", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Map<String, String>> handleUnauthorized(UnauthorizedException exception) {
        Map<String, String> body = Map.of("Error", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, String>> handleAccessDanied(AccessDeniedException exception) {
        Map<String, String> body = Map.of("Erro", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
    }
}
