package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissingArgumentException extends RuntimeException {
    private String errorCode = "CODE4";

    public MissingArgumentException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public MissingArgumentException(String message) {
        super(message);
    }

    public MissingArgumentException(Long id) {
        super(String.format("Arg with %d not found", id));
    }

    public String getErrorCode() {
        return errorCode;
    }



}
