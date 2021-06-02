package com.example.CrudCheckpoint.controller;

import com.example.CrudCheckpoint.domain.Result;
import com.example.CrudCheckpoint.domain.User;
import com.example.CrudCheckpoint.domain.UserAuthentication;
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
    public Result delete(@RequestBody User userInput,@PathVariable Long id) {
       User user = this.repository.findById(id).get();
       user.setEmail(userInput.getEmail());
       user.setPassword(userInput.getPassword());
       this.repository.delete(user);

       Result response = new Result();
       response.count = this.repository.count();
       return response;
    }


    @PostMapping("users/authenticate")
    public UserAuthentication authenticate(@RequestBody User userInput) {
        User user = this.repository.findByEmail(userInput.getEmail());
        UserAuthentication response = new UserAuthentication();
        if (userInput.getPassword().equals(user.getPassword())) {
            response.setAuthenticated(true);
            response.setUser(user);
            return response;
        }else {
            response.setAuthenticated(false);
            return response;
        }
    }

}
