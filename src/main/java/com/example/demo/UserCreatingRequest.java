package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record UserCreatingRequest(
        @NotBlank @Length(max = 48) String name,
        @NotBlank @Length(max = 24) String password
) {
}
