package com.example.demo;

public record UserResponse(
        Long id,
        String name,
        Role role
) {
}
