package com.example.helloworld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.entities.User;
import com.example.helloworld.model.UserDetails;
import com.example.helloworld.services.UserService;

@RestController
public class HelloWorldController {

	@Autowired
	private UserService userService;
	
    @GetMapping("/hello")
    public String sendGreetings() {
        return "Hello, World!";
    }
    
    @GetMapping("/userbean")
    public UserDetails helloWorldBean() {
        UserDetails ud =  new UserDetails("Souvik","Basu",37);
        return ud;
    }
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping(path="/createUser", produces = "application/json", consumes = "application/json")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }
    
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }
    
    @DeleteMapping("/users/{id}")
    public void updateUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
