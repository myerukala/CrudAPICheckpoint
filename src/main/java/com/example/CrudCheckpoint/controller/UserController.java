package com.example.CrudCheckpoint.controller;

import com.example.CrudCheckpoint.domain.User;
import com.example.CrudCheckpoint.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("users")
    public Iterable<User> all() {
        return this.repository.findAll();
    }

    @PostMapping("user")
    public User create(@RequestBody User user) {
        return this.repository.save(user);
    }

    @GetMapping("user/id/{id}")
    public Optional<User> read(@PathVariable Long id) {
        return this.repository.findById(id);
    }

}
