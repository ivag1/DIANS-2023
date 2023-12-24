package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.model.exceptions.PasswordsDoNotMatchException;
import com.example.demo.model.exceptions.UserNotFoundException;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
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
