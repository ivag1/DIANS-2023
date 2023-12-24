package com.example.demo.service.impl;

import com.example.demo.model.Place;
import com.example.demo.model.User;
import com.example.demo.model.exceptions.PlaceNotFoundException;
import com.example.demo.model.exceptions.UserNotFoundException;
import com.example.demo.repository.PlacesRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PlacesRepository placesRepository;
    @PersistenceContext
    private EntityManager entityManager;

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
    @Transactional
    public void addPlaceToFavourites(String username, Long placeId) {
        Optional<User> user = this.usersRepository.findUserByUsername(username);
        Optional<Place> place = this.placesRepository.findById(placeId);
        if(user.isPresent()){
            if(place.isPresent()) {
                user.get().setFavoritePlace(place.get());
                this.usersRepository.save(user.get());
                this.entityManager.refresh(user.get());
            }
            else
                throw new PlaceNotFoundException(placeId);
        }
        else
            throw new UserNotFoundException(username);
    }
}
