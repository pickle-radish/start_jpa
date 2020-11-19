package com.example.jpa.start.jpa.dto;

import com.example.jpa.start.jpa.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    private Integer orderId;

    private String orderName;

    private Integer userId;

    public Order toEntity() {
        return Order.builder()
                .orderId(orderId)
                .orderName(orderName)
//                .user(user)
                .userId(userId)
                .build();
    }
}
