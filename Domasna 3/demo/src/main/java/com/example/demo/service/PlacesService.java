package com.example.demo.service;

import com.example.demo.model.Place;

import java.util.List;
import java.util.Optional;

public interface PlacesService {
    List<Place> findAllPlaces();
    Place findPlaceById(Long id);
    List<Place> findByText(String text);
    Place findPlaceByName(String placeName);

    void refreshDatabase();

    List<Place> readFromCSV();
}
