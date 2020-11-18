package com.example.jpa.start.jpa.repository;

import com.example.jpa.start.jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
