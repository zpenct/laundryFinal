package com.example.demo.exception;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
        logError();
    }

    private void logError() {
        System.out.println("Error Log: User Authentication - " + getMessage());
    }

}

