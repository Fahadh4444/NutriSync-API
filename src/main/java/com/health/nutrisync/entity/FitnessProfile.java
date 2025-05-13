package com.health.nutrisync.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="fitness_profile")
public class FitnessProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private int gender;

    @Column(nullable = false)
    private double height; // in cm

    @Column(nullable = false)
    private double weight; // in kg

    @Column(nullable = false)
    private int age; // user age

    @Column(nullable = false)
    private int activityLevel; // Example: Sedentary, Moderate, Active

    @Column(nullable = false)
    private double bmi;

    @Column(nullable = false)
    private double bodyFatPercentage;

    @Column(nullable = false)// in percentage
    private double bmr;

    @Column(nullable = false)
    private double tdee;

    @Column(nullable = false)
    private LocalDate updatedAt;

    public FitnessProfile(User user, int gender, double height, double weight, int age, int activityLevel, double bmi, double bodyFatPercentage, double tdee, double bmr, LocalDate updatedAt) {
        this.user = user;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.activityLevel = activityLevel;
        this.bmi = bmi;
        this.bodyFatPercentage = bodyFatPercentage;
        this.tdee = tdee;
        this.bmr = bmr;
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTdee() {
        return tdee;
    }

    public void setTdee(double tdee) {
        this.tdee = tdee;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public double getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(double bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
