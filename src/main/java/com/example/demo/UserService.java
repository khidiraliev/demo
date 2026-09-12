package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User save(String name, String passwordHash) {
        User user = new User();

        user.setName(name);
        user.setPasswordHash(passwordHash);
        user.setRole(Role.USER);

        repository.save(user);

        log.debug("Пользователь {} создан.", user.getId());

        return user;
    }

    public User getUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с id %s не найден.".formatted(id)));
    }
}
