package com.example.demo.model.exceptions;

public class PlaceNotFoundException extends RuntimeException {
    public PlaceNotFoundException(Long id) {
        super("Place with id " + id + " not found");
    }
}
