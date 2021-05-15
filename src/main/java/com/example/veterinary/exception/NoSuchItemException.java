package com.example.veterinary.exception;

public class NoSuchItemException extends RuntimeException {
    public NoSuchItemException(String message) {
        super(message);
    }

    public NoSuchItemException() {
        super();
    }
}
