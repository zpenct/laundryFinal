package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmailAlreadyUsedException extends AuthenticationException {

    public EmailAlreadyUsedException(String email) {
        super("Email " + email + " has already been used.");
    }
}

