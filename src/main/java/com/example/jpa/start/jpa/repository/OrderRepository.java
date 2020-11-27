package com.example.jpa.start.jpa.repository;

import com.example.jpa.start.jpa.entity.Order;
import com.example.jpa.start.jpa.entity.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
    List<Order> findAllByUserId(Integer userId);
}
