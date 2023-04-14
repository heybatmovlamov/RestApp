package com.example.restapi.Repo;

import com.example.restapi.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<Users,Long> {

}
