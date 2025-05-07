package com.project.AppointEase.controller;

import com.project.AppointEase.model.User;
import com.project.AppointEase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    //Creating a user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    //Get All users
    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    //Get user by ID
    @GetMapping
    public User getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    //Delete user by ID
    @DeleteMapping
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    //Update  user by ID
    @PatchMapping
    public User updateUser(@PathVariable Long id , @RequestBody User updatedUser){
        return userService.updateUser(id , updatedUser);
    }




}
