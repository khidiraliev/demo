package com.example.demo.api.dto;

import com.example.demo.domain.Role;

public record UserResponse(
        Long id,
        String name,
        Role role
) {
}
