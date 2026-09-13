package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//TODO добавить пагинацию
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.example.demo.UserResponse(u.id, u.name, u.role) " +
            "FROM User u")
    List<UserResponse> findAllUserResponses();

    @Query("SELECT new com.example.demo.UserResponse(u.id, u.name, u.role) " +
            "FROM User u " +
            "WHERE u.id = :id")
    Optional<UserResponse> findUserResponseById(Long id);
}
