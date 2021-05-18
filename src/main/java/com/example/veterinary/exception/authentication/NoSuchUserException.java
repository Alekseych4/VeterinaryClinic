package com.example.veterinary.exception.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchUserException extends AuthenticationException {
    private HttpStatus errorStatus;

    public NoSuchUserException(){
        this("No such user");
    }
    public NoSuchUserException(String message) {
        super(message);
        errorStatus = HttpStatus.NOT_FOUND;
    }

    public HttpStatus getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(HttpStatus errorStatus) {
        this.errorStatus = errorStatus;
    }
}
