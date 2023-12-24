package com.example.demo.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Passwords do not match");
    }

    public PasswordsDoNotMatchException(String username){
        super("Wrong password for user "+username);
    }
}
