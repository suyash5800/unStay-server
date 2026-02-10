package com.unstay.server.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.unstay.server.services.UserServices;
import com.unstay.server.entity.User;




@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "https://um-stay-client.vercel.app")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
   public User createUser(@RequestBody User user){
        return userServices.saveUser(user);
    }

    
}
