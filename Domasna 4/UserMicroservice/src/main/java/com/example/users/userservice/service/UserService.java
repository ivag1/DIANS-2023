package com.example.users.userservice.service;

import com.example.users.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
    User deleteUserByUsernameAndPassword(String username, String password);
    void addPlaceToFavourites(String username, String placeName);
}

