package com.practice.classroom.service;

import com.practice.classroom.entity.User;
import com.practice.classroom.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public User createUser(User user) {

      return userRepo.save(user);
    }
}
