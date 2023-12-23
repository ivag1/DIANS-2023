package com.example.demo.model.exceptions;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String message) {
        super("Username "+message+" not found");
    }
}
