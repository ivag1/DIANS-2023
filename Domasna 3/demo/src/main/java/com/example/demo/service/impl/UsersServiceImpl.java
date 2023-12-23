package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.model.exceptions.UsernameNotFoundException;
import com.example.demo.model.exceptions.WrongPasswordException;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByUsername(String username) {
        return this.usersRepository.findUserByUsername(username);
        //returns null
    }

    public User checkPasswordForUsername(String username, String password) {
        User user = this.findUserByUsername(username);
        if(user.getPassword().equals(passwordEncoder.encode(password)))
            return user;
        throw new WrongPasswordException(username);
    }

    @Override
    public User login(String username, String password) {
        if(this.findUserByUsername(username)!=null)
            return this.checkPasswordForUsername(username,passwordEncoder.encode(password));
        throw new UsernameNotFoundException(username);
    }

    @Override
    public User register(String username, String password, String email) {
        return this.usersRepository.save(new User(username,passwordEncoder.encode(password),email));
    }


}
