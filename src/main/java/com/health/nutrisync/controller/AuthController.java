package com.health.nutrisync.controller;

import com.health.nutrisync.dto.UserRequestDTO;
import com.health.nutrisync.dto.UserResponseDTO;
import com.health.nutrisync.service.AuthService;
import com.health.nutrisync.service.EmailVerificationService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    EmailVerificationService emailVerificationService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> signup(@Valid @RequestBody UserRequestDTO UserRequest) throws MessagingException {
        UserResponseDTO userResponse = authService.registerUser(UserRequest);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam String token){
        String result = emailVerificationService.verifyUser(token);
        return ResponseEntity.ok(result);
    }
}
