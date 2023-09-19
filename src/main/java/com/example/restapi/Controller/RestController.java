package com.example.restapi.Controller;

import com.example.restapi.Entity.User;
import com.example.restapi.Exception.ApiRequestException;
import com.example.restapi.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        Time t = new Time(1);
        System.out.println("logining = " + t.getTime());
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable("id") long id) {
        return userRepo.findById(id).orElseThrow(()-> new ApiRequestException("not found"));

    }


    @PostMapping(value = "/save")
//    @PreAuthorize(value = "hasAuthority('')")
    public String save(@RequestBody User users) {
        userRepo.save(users);
        return "Saved...";

    }

    @DeleteMapping(value = "delete/{id}")
    public String delete(@PathVariable long id) {
        userRepo.deleteById(id);
        return "Deleted user with the id : " + id;
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User users) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(users.getFirstName());
        updatedUser.setLastName(users.getLastName());
//        updatedUser.setOccupation(users.getOccupation());
//        updatedUser.setAge(users.getAge());
        userRepo.save(updatedUser);
        return "updated...";
    }
}
