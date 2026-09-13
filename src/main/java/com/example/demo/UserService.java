package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserResponse save(UserCreatingRequest request) {
        String passwordHash = encoder.encode(request.password());

        User user = new User();

        user.setName(request.name());
        user.setPasswordHash(passwordHash);
        user.setRole(Role.USER);

        repository.save(user);

        log.debug("Пользователь {} создан.", user.getId());

        return new UserResponse(user.getId(), user.getName(), user.getRole());
    }

    public List<UserResponse> getAllUsers() {
        return repository.findAllUserResponses();
    }

    public UserResponse getUser(Long id) {
        return repository.findUserResponseById(id)
                .orElseThrow(() -> new IllegalArgumentException("Пользователь с id %d не найден.".formatted(id)));
    }
}
