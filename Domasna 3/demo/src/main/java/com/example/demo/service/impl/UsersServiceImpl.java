package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
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
}
