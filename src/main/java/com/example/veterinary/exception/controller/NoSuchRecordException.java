package com.example.veterinary.exception.controller;

import com.example.veterinary.exception.VeterinaryApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchRecordException extends VeterinaryApplicationException {
    public NoSuchRecordException() {
        this("No such record with these parameters");
    }

    public NoSuchRecordException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
