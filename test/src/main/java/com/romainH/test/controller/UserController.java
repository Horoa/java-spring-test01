package com.romainH.test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romainH.test.model.User;
import com.romainH.test.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
	this.repository = repository;
    }

    @GetMapping
    public List<User> getAll() {
	return repository.findAll();
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {
	return repository.save(user);
    }

}
