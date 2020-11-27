package com.example.jpa.start.jpa.repository;

import com.example.jpa.start.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserId(Integer userId);

    List<User> findAllByClassNum(String classNum);

    User findByUserName(String userName);
}













