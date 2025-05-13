package com.health.nutrisync.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.health.nutrisync.entity.User;
import com.health.nutrisync.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EmailVerificationService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    private final String SECRET_KEY = "mysecretkeymysecretkeymysecretkeymysecretkeymysecretkeymysecretkeymysecretkeymysecretkey";
    private final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    // Generate Token
    public String generateVerificationToken(String email) {
        return JWT.create()
                .withSubject(email)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    // Send Verification Email
    public void sendVerificationEmail(User user) throws MessagingException {
        String token = generateVerificationToken(user.getEmail());
        String verificationUrl = "http://localhost:8081/api/auth/verify?token=" + token;

        // Send Email
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(user.getEmail());
        helper.setSubject("Verify Your Email");
        helper.setText("<h3>Click below to verify your email:</h3>"
                + "<a href='" + verificationUrl + "'>Verify Email</a>", true);
        helper.setFrom("livetoexplore333@gmail.com");

        mailSender.send(mimeMessage);
    }

    // Validate JWT Token and verify User
    public String verifyUser(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
            String email = decodedJWT.getSubject();

            Optional<User> optionalUser = userRepository.findByEmail(email);
            if (optionalUser.isEmpty()) {
                return "User not found!";
            }

            User user = optionalUser.get();
            if (user.getisVerified()) {
                return "User already verified!";
            }

            user.setisVerified(true);
            userRepository.save(user);

            return "Email verified successfully!";
        } catch (JWTVerificationException e) {
            return "Invalid or expired token!";
        }

    }
}
