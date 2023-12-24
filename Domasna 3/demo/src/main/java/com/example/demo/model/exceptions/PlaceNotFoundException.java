package com.example.demo.model.exceptions;

public class PlaceNotFoundException extends RuntimeException {
    public PlaceNotFoundException(String id) {
        super("Place with name " + id + " not found");
    }
}
