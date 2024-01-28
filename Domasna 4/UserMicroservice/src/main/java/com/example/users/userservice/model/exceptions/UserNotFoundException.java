package com.example.users.userservice.model.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String username) {
        super("User with username "+username+" not found");
    }
}

