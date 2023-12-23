package com.example.demo.model.exceptions;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(String u) {
        super("Wrong password for username "+u);
    }
}
