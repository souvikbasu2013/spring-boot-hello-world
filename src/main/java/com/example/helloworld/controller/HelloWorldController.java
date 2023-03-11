package com.example.helloworld.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.helloworld.entities.User;
import com.example.helloworld.exception.UserNameNotFoundException;
import com.example.helloworld.exception.UserNotFoundException;
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
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
    
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long id) {
        try {
			return userService.getUser(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
    }
    
    @GetMapping("/users/name/{name}")
    public User getUserByName(@PathVariable("name") String name) throws UserNameNotFoundException {
			return userService.getUserByName(name);		
    }

    
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        
        try {
        	return userService.updateUser(user, id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
