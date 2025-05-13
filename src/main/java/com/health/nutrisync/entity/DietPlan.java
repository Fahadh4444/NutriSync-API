package com.health.nutrisync.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "diet_plan")
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String[] breakfat;

    @Column(nullable = false)
    private String[] lunch;

    @Column(nullable = false)
    private String[] snacks;

    @Column(nullable = false)
    private String[] dinner;

    @Column(nullable = false)
    private String[] suppliments;

    @Column(nullable = false)
    private LocalDate updatedAt;

    public DietPlan() {}

    public DietPlan(Long id, LocalDate updatedAt, String[] suppliments, String[] dinner, String[] snacks, String[] lunch, String[] breakfat, User user) {
        this.id = id;
        this.updatedAt = updatedAt;
        this.suppliments = suppliments;
        this.dinner = dinner;
        this.snacks = snacks;
        this.lunch = lunch;
        this.breakfat = breakfat;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String[] getSuppliments() {
        return suppliments;
    }

    public void setSuppliments(String[] suppliments) {
        this.suppliments = suppliments;
    }

    public String[] getLunch() {
        return lunch;
    }

    public void setLunch(String[] lunch) {
        this.lunch = lunch;
    }

    public String[] getDinner() {
        return dinner;
    }

    public void setDinner(String[] dinner) {
        this.dinner = dinner;
    }

    public String[] getSnacks() {
        return snacks;
    }

    public void setSnacks(String[] snacks) {
        this.snacks = snacks;
    }

    public String[] getBreakfat() {
        return breakfat;
    }

    public void setBreakfat(String[] breakfat) {
        this.breakfat = breakfat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
