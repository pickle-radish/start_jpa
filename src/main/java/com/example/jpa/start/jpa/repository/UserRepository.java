package com.example.jpa.start.jpa.repository;

import com.example.jpa.start.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
