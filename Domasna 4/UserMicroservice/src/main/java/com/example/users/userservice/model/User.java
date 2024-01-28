package com.example.users.userservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @NotEmpty
   @NotNull
    @Column(unique = true)
    private String username;

    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String email;

    @NotEmpty
    @NotNull
    private String password;

    /*@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "favorite_places",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "place_id"))
    //@MapKey(name = "name")
    */

    @ElementCollection
    private List<String> favoritePlaces;


    public User(String username, String name, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.favoritePlaces = new ArrayList<>();
    }

    public void setFavoritePlace(String favoritePlace) {
        this.favoritePlaces.add(favoritePlace);
    }
}
