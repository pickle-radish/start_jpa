package com.example.jpa.start.jpa.dto;


import com.example.jpa.start.jpa.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderResponseDTO {

    private Integer orderId;

    private String orderName;

    private UserResponseDTO user;

    public OrderResponseDTO(Order order) {
        this.orderId = order.getOrderId();
        this.orderName = order.getOrderName();
        this.user = new UserResponseDTO(order.getUser());
    }
}
