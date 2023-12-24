package com.example.demo.service.impl;

import com.example.demo.model.Place;
import com.example.demo.model.exceptions.PlaceNotFoundException;
import com.example.demo.repository.PlacesRepository;
import com.example.demo.service.PlacesService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
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
    public Place findPlaceById(Long id) {
        return this.placesRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Place> findByText(String text) {
        return placesRepository.findAll().stream().filter(p->p.getName().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public Place findPlaceByName(String placeName) {
        return this.placesRepository.findPlaceByName(placeName).orElseThrow();
    }

    @Override
    @Transactional
    public void refreshDatabase() {
        List<Place> locations = readFromCSV();
        placesRepository.deleteAll();
        placesRepository.saveAll(locations);
    }


    public List<Place> readFromCSV() {
        List<Place> locations = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader("data.csv"))) {
            List<String[]> rows = reader.readAll();

            for (String[] row : rows) {
                // Assuming your CSV has columns like id, name, latitude, longitude
                // Long id = Long.parseLong(row[0]);
                String name = row[2];
                Double latitude = Double.parseDouble(row[0]);
                Double longitude = Double.parseDouble(row[1]);

                Place location = new Place(latitude, longitude, name, "");
                locations.add(location);
            }
        } catch (IOException | CsvException e) {
            // Handle exceptions (e.g., log or throw a custom exception)
            e.printStackTrace();
        }

        return locations;
    }
}
