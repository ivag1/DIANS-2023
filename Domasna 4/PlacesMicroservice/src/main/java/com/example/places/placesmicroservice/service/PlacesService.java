package com.example.places.placesmicroservice.service;

import com.example.places.placesmicroservice.model.Place;

import java.util.List;

public interface PlacesService {
    List<Place> findAllPlaces();
    Place findPlaceById(Long id);
    List<Place> findByText(String text);
    Place findPlaceByName(String placeName);

    void refreshDatabase();

    List<Place> readFromCSV();
}
