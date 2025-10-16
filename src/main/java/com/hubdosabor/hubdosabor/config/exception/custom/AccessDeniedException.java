package com.hubdosabor.hubdosabor.config.exception.custom;


public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}
