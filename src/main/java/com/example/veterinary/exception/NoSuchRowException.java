package com.example.veterinary.exception;

public class NoSuchRowException extends RuntimeException {
    public NoSuchRowException(String message) {
        super(message);
    }

    public NoSuchRowException() {
        super();
    }
}
