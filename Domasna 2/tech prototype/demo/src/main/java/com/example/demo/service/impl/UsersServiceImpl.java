package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public List<User> findAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return findAllUsers().stream()
                .filter(i -> i.getUsername().equals(username))
                .findFirst();
    }
}
