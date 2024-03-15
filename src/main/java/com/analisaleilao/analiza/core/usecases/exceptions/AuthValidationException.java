package com.analisaleilao.analiza.core.usecases.exceptions;

public class AuthValidationException extends RuntimeException {
    public AuthValidationException(String message) {
        super(message);
    }
}
