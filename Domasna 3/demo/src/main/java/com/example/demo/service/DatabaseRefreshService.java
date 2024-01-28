package com.example.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DatabaseRefreshService {


    PlacesService placesService;

    public DatabaseRefreshService(PlacesService placesService){
        this.placesService = placesService;
    }


    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // 24 hours in ms
    public void refreshDatabase() {
        placesService.refreshDatabase();
    }
}
