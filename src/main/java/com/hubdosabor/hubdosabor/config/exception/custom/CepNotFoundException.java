package com.hubdosabor.hubdosabor.config.exception.custom;

public class CepNotFoundException extends RuntimeException{
    public CepNotFoundException(String message) {
        super(message);
    }
}
