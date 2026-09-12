package com.example.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @PostMapping("/new")
    public UserResponse createUser(@RequestBody @NotNull @Valid UserCreatingRequest request) {
        return service.save(request);
    }
}
