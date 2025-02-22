package com.health.nutrisync.dao;

import com.health.nutrisync.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
