package com.health.nutrisync.service;

import com.health.nutrisync.dao.userRepository;
import com.health.nutrisync.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    private userRepository userRepository;

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
