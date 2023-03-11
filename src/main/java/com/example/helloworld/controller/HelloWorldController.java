package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.model.UserDetails;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sendGreetings() {
        return "Hello, World!";
    }
    
    @GetMapping("/userbean")
    public UserDetails helloWorldBean() {
        UserDetails ud =  new UserDetails("Souvik","Basu",37);
        return ud;
    }
}
