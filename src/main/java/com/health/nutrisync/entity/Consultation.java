package com.health.nutrisync.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @OneToOne
    @JoinColumn(name = "dietitian_id", nullable = false, unique = true)
    private Dietitian dietitian;

    @Column(nullable = false)
    private LocalDateTime sessionTime;

    @Column(nullable = false)
    private int status;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    @Column(columnDefinition = "TEXT")
    private String dietitianNotes;

    public Consultation() {}

    public Consultation(Long id, Dietitian dietitian, User user, LocalDateTime sessionTime, String feedback, int status, String dietitianNotes) {
        this.id = id;
        this.dietitian = dietitian;
        this.user = user;
        this.sessionTime = sessionTime;
        this.feedback = feedback;
        this.status = status;
        this.dietitianNotes = dietitianNotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDietitianNotes() {
        return dietitianNotes;
    }

    public void setDietitianNotes(String dietitianNotes) {
        this.dietitianNotes = dietitianNotes;
    }

    public Dietitian getDietitian() {
        return dietitian;
    }

    public void setDietitian(Dietitian dietitian) {
        this.dietitian = dietitian;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(LocalDateTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
