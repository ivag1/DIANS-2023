package com.example.users.userservice.service.impl;

import com.example.users.userservice.model.User;
import com.example.users.userservice.model.exceptions.PasswordsDoNotMatchException;
import com.example.users.userservice.model.exceptions.UserNotFoundException;
import com.example.users.userservice.repository.UserRepository;
import com.example.users.userservice.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {
        Optional<User> user = this.usersRepository.findUserByUsername(username);
        if(user.isPresent()){
            if(passwordEncoder.matches(password, user.get().getPassword()))
                return user.get();
            throw new PasswordsDoNotMatchException(username);
        }
        throw new UserNotFoundException(username);
    }

    @Override
    public User register(String username, String name, String email, String password, String repeatPassword) {
        if(!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        return this.usersRepository.save(new User(username, name, email, passwordEncoder.encode(password)));
    }
}