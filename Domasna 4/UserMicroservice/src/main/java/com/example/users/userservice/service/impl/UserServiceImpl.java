package com.example.users.userservice.service.impl;

import com.example.users.userservice.model.User;
import com.example.users.userservice.model.exceptions.UserNotFoundException;
import com.example.users.userservice.repository.UserRepository;
import com.example.users.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository usersRepository;
    //private final PlacesRepository placesRepository;

    public UserServiceImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
      //  this.placesRepository = placesRepository;
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
        Optional<User> user = this.usersRepository.findById(username);
        //Optional<Place> place = this.placesRepository.findById(placeId);
        if(user.isPresent()){
                user.get().setFavoritePlace(placeName);
                this.usersRepository.save(user.get());
        }
        else
            throw new UserNotFoundException(username);
    }
}
