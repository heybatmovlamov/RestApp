package com.example.restapi.Repo;

import com.example.restapi.Controller.RestController;
import com.example.restapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

//        Optional<User> findByEmail(String email);
}

