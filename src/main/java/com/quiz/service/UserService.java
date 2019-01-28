package com.quiz.service;

import com.quiz.api.User;
import com.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }

}
