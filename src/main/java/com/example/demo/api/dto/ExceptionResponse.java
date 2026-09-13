package com.example.demo.api.dto;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public record ExceptionResponse(
        Instant timestamp,
        HttpStatus status,
        String error,
        String message,
        String path
) {
}
