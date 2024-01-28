package com.example.users.userservice.service;

import com.example.users.userservice.model.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username, String name, String email, String password, String repeatPassword);
}

