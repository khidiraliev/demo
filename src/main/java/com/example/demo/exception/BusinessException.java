package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {
    private HttpStatus status;
    private String error;

    public BusinessException(String message, HttpStatus status, String error) {
        super(message);
    }
}
