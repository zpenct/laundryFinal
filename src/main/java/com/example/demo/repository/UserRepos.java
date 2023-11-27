package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepos extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}