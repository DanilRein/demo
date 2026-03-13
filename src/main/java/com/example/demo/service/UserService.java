package com.example.demo.service;

import com.example.demo.resourses.User;
import com.example.demo.resourses.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
            private final PasswordEncoder passwordEncoder;
            public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
                this.userRepository=userRepository;
                this.passwordEncoder=passwordEncoder;
            }
            public User register(User user){
                if(userRepository.findByUsername(user.getUsername()).isPresent()){
                    throw new IllegalStateException("Username already exists");
                }
                if(userRepository.findByEmail(user.getUsername()).isPresent()){
                    throw new IllegalStateException("Email already exists");
                }
                String encodedPassword =passwordEncoder.encode(user.getPassword());
                user.setPassword(encodedPassword);
                return userRepository.save(user);
            }
            public Optional<User> authenticate(String username, String password){
                Optional<User> userOptional=userRepository.findByUsername(username);
                if(userOptional.isPresent()){
                    User user = userOptional.get();
                    if(passwordEncoder.matches(password, user.getPassword())){
                        return Optional.of(user);
                    }
                }
                return Optional.empty();
            }
}
