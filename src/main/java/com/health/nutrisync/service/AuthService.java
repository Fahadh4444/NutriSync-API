package com.health.nutrisync.service;

import com.health.nutrisync.dto.UserRequestDTO;
import com.health.nutrisync.dto.UserResponseDTO;
import com.health.nutrisync.entity.User;
import com.health.nutrisync.repository.UserRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailVerificationService emailVerificationService;

    public UserResponseDTO registerUser(UserRequestDTO userRequest) throws MessagingException {
        // Check if email already exists
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use!");
        }

        // Create User
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setCreatedAt(LocalDateTime.now());

        // Hashing the password
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        User registeredUser = userRepository.save(user);

        emailVerificationService.sendVerificationEmail(registeredUser);
        return new UserResponseDTO(registeredUser.getId(), registeredUser.getUsername(), registeredUser.getEmail(), registeredUser.getCreatedAt());

    }
}
