package com.example.demo.api.controller;

import com.example.demo.api.dto.ExceptionResponse;
import com.example.demo.exception.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException exception, HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                exception.getStatus(),
                exception.getError(),
                exception.getMessage(),
                request.getMethod() + " " + request.getRequestURI()
        );

        log.warn("Business exception: {}", response);

        return ResponseEntity.status(response.status())
                .body(response);
    }
}
