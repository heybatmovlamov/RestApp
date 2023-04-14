package com.example.restapi.Controller;

import com.example.restapi.Entity.Users;
import com.example.restapi.Repo.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<Users> getUsers() {
        return userRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String save(@RequestBody Users users){
         userRepo.save(users);
         return "Saved...";

    }
    @DeleteMapping(value = "delete/{id}")
    public String delete(@PathVariable long id){
        userRepo.deleteById(id);
        return "Deleted user with the id : "+ id;
    }
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id ,@RequestBody Users users){
        Users updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(users.getFirstName());
        updatedUser.setLastName(users.getLastName());
        updatedUser.setOccupation(users.getOccupation());
        updatedUser.setAge(users.getAge());
        userRepo.save(updatedUser);
        return "updated...";
    }
}
