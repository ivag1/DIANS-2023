package com.example.demo.service.impl;

import com.example.demo.model.Place;
import com.example.demo.repository.PlacesRepository;
import com.example.demo.service.PlacesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<Place> findByText(String text) {
        return placesRepository.findAll().stream().filter(p->p.getName().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());
    }
}
