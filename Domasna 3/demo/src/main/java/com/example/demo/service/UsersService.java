package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
    User deleteUserByUsernameAndPassword(String username, String password);
}
