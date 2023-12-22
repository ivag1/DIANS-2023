package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    Optional<User> findByUsername(String username);
}
