package com.example.jpa.start.jpa.repository;

import com.example.jpa.start.jpa.entity.Order;
import com.example.jpa.start.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUser(User user);
    List<Order> findAllByUserId(Integer userId);
}
