package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    private final HttpStatus status;
    private final String error;

    public BusinessException(String message, HttpStatus status, String error) {
        this.status = status;
        this.error = error;

        super(message);
    }
}
