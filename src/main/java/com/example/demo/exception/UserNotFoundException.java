package com.example.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserNotFoundException extends BusinessException {
    private final Long id;

    public UserNotFoundException(Long id) {
        this.id = id;

        super(
                "User with id " + id + " not found",
                HttpStatus.NOT_FOUND,
                "User not found"
        );
    }


}
