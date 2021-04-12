package com.example.demo.service.validation;

/**
 * Custom exception class
 *
 * @version 1.0
 */
public class RequesterException extends RuntimeException {
    public RequesterException(String message) {
        super(message);
    }
}
