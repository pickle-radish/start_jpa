package com.example.jpa.start.jpa.dto;


import com.example.jpa.start.jpa.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderWithUserResponseDTO {

//    private Integer orderId;

    private UserResponseDTO user;
    private String orderName;


    public OrderWithUserResponseDTO(Order order) {
//        this.orderId = order.getOrderId();
        this.orderName = order.getOrderName();
        this.user = new UserResponseDTO(order.getUser());
    }
}