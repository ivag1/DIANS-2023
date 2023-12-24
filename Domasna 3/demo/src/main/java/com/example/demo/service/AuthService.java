package com.example.demo.service;

import com.example.demo.model.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username, String name, String email, String password, String repeatPassword);
}
