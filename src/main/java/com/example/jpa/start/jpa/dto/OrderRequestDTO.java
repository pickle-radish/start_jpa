package com.example.jpa.start.jpa.dto;

import com.example.jpa.start.jpa.entity.Order;
import com.example.jpa.start.jpa.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private Integer orderId;

    private String orderName;

    private Integer userId;

    public Order toEntity(User user) {
        return Order.builder()
                .orderId(orderId)
                .orderName(orderName)
                .user(user)
                .build();
    }
}
