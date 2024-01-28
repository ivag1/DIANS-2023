package com.example.places.placesmicroservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Data
@Entity
@Table(name = "locations")
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeId;

    @NotEmpty
    @NotNull
    private Double latitude;

    @NotEmpty
    @NotNull
    private Double longitude;

    @NotEmpty
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "favoritePlaces")
    private List<User> favoritedByUsers;

    public Place(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }
}
