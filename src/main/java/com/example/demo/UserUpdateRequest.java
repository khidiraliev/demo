package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record UserUpdateRequest(
        @NotNull @Positive Long id,
        @NotBlank @Length(max = 48) String name,
        @NotBlank @Length(max = 24) String password,
        @NotBlank Role role
) {
}
