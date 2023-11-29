package com.example.demo.exception;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String message) {
        super(message);
        logError();
    }

    private void logError() {
        // Log error ke sistem atau layanan log yang sesuai
        System.out.println("Error Log: User Authentication - " + getMessage());
    }

}

