package com.example.veterinary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VeterinaryApplicationException extends RuntimeException {
    private HttpStatus errorStatus;
    private static final String MESSAGE = "Application is unable to process this request";

    public VeterinaryApplicationException(){
        this(MESSAGE, HttpStatus.BAD_REQUEST);
    }
    public VeterinaryApplicationException(String message){
        this(message, HttpStatus.BAD_REQUEST);
    }
    public VeterinaryApplicationException(HttpStatus httpStatus){
        super(MESSAGE);
        errorStatus = httpStatus;
    }
    public VeterinaryApplicationException(String message, HttpStatus httpStatus) {
        super(message);
        errorStatus = httpStatus;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(HttpStatus errorStatus) {
        this.errorStatus = errorStatus;
    }
}
