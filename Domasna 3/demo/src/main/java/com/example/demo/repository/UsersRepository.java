package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, String> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUsernameAndPassword(String username,String password);
    Optional<User> deleteUserByUsernameAndPassword(String username, String password);
}
