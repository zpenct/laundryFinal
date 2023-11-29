package com.example.demo.OwnValidation;

public class Validation {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
