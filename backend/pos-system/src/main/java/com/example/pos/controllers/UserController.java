package com.example.pos.controllers;

import java.util.List;

import com.example.pos.exceptionHandlers.UserNotFoundException;
import com.example.pos.model.User;
import com.example.pos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600,allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    User one(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
