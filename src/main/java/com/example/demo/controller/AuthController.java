package com.example.demo.controller;

import com.example.demo.resourses.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        try{
            User registeredUser = userService.register(user);
            return ResponseEntity.ok("User registered successfully: "+ registeredUser.getUsername());
        } catch (IllegalAccessError e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials){
        String username = credentials.get("username");
        String password = credentials.get("password");
        Optional<User> userOptional=userService.authenticate(username, password);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return ResponseEntity.ok("Login successful!\nWelcome, "+user.getUsername());
        }
        else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
