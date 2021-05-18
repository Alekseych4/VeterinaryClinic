package com.example.veterinary.exception.handler;

import com.example.veterinary.exception.VeterinaryApplicationException;
import com.example.veterinary.exception.authentication.NoSuchUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(VeterinaryApplicationException.class)
    @ResponseBody
    public ResponseEntity handleException(VeterinaryApplicationException e) {
        return ResponseEntity.status(e.getErrorStatus()).body(e.getMessage());
    }

    @ExceptionHandler(NoSuchUserException.class)
    @ResponseBody
    public ResponseEntity handleAuthCustomException(NoSuchUserException e){
        return ResponseEntity.status(e.getErrorStatus()).body(e.getMessage());
    }
}
