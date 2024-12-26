package com.test.controller;


import com.test.model.User;
import com.test.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8086") 
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String registerUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        // Check if there are any validation errors
        if (bindingResult.hasErrors()) {
            // Handle errors here (e.g., return error messages)
            return "Error: " + bindingResult.getAllErrors();
        }

        // Save the user to the database if validation passes
        userService.register(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.authenticate(username, password);
    }
}

