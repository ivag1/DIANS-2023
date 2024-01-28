package com.example.places.placesmicroservice.repository;

import com.example.places.placesmicroservice.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends JpaRepository<Place,Long> {
    Place findPlaceByName(String name);
}
