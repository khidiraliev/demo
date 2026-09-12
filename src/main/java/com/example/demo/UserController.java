package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final PasswordEncoder encoder;

    @PostMapping("/new")
    public User createUser(@RequestParam String name, @RequestParam String password) {
        String passwordHash = encoder.encode(password);
        return service.save(name, passwordHash);
    }
}
