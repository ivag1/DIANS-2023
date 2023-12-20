package com.example.demo.service.impl;

import com.example.demo.model.Place;
import com.example.demo.repository.PlacesRepository;
import com.example.demo.service.PlacesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacesServiceImpl implements PlacesService {
    private final PlacesRepository placesRepository;

    public PlacesServiceImpl(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }


    @Override
    public List<Place> findAllPlaces() {
        return placesRepository.findAll();
    }

    @Override
    public Optional<Place> findPlaceById(Long id) {
        return placesRepository.findById(id);
    }
}
