package com.unstay.server.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.unstay.server.services.UserServices;
import com.unstay.server.entity.User;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
   public User createUser(@RequestBody User user){
        return userServices.saveUser(user);
    }

    
}
