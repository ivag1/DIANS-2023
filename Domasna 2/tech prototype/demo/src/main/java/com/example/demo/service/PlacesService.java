package com.example.demo.service;

import com.example.demo.model.Place;

import java.util.List;
import java.util.Optional;

public interface PlacesService {
    List<Place> findAllPlaces();
    Optional<Place> findPlaceById(Long id);
}
