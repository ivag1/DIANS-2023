package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    User findUserByUsername(String username);
    User checkPasswordForUsername(String username, String password);
    User login(String username,String password);
    User register (String username, String password, String email);
}
