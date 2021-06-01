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

    @GetMapping("users/{id}")
    public Optional<User> read(@PathVariable Long id) {
        return this.repository.findById(id);
    }


    @PatchMapping("users/{id}")
    public void patchUpdate(@RequestBody User userInput,@PathVariable Long id) {
        User user = this.repository.findById(id).get();
        user.setEmail(userInput.getEmail());
        user.setPassword(userInput.getPassword());
        this.repository.save(user);
    }

    @DeleteMapping("users/{id}")
    public void delete(@RequestBody User userInput,@PathVariable Long id) {
       User user = this.repository.findById(id).get();
       user.setEmail(userInput.getEmail());
       user.setPassword(userInput.getPassword());
       this.repository.delete(user);
    }
}
