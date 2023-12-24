package com.example.demo.service.impl;

import com.example.demo.model.Place;
import com.example.demo.model.User;
import com.example.demo.model.exceptions.PlaceNotFoundException;
import com.example.demo.model.exceptions.UserNotFoundException;
import com.example.demo.repository.PlacesRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PlacesRepository placesRepository;

    public UsersServiceImpl(UsersRepository usersRepository, PlacesRepository placesRepository) {
        this.usersRepository = usersRepository;
        this.placesRepository = placesRepository;
    }

    @Override
    public User findUserByUsername(String username) {
        return this.usersRepository.findUserByUsername(username).orElseThrow();
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return this.usersRepository.findUserByUsernameAndPassword(username,password).orElseThrow();
    }

    @Override
    public User deleteUserByUsernameAndPassword(String username, String password) {
        return this.usersRepository.deleteUserByUsernameAndPassword(username,password).orElseThrow();
    }

    @Override
    public void addPlaceToFavourites(String username, String placeName) {
        Optional<User> user = this.usersRepository.findUserByUsername(username);
        Optional<Place> place = this.placesRepository.findPlaceByName(placeName);
        if(user.isPresent()){
            if(place.isPresent()) {
                user.get().setFavoritePlace(place.get());
                this.usersRepository.save(user.get());
            }
            else
                throw new PlaceNotFoundException(placeName);
        }
        else
            throw new UserNotFoundException(username);
    }
}
