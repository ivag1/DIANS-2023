package com.example.users.userservice.repository;

import com.example.users.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByUsernameAndPassword(String username,String password);
    Optional<User> deleteUserByUsernameAndPassword(String username, String password);

    Optional<User> findById(String username);
}
