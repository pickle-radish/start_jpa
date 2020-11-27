package com.example.jpa.start.jpa.dto;


import com.example.jpa.start.jpa.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderResponseDTO {

//    private Integer orderId;

    private Integer userId;

    private Integer itemId;

    private String orderName;

//    private UserResponseDTO user;

    public OrderResponseDTO(Order order) {
//        this.orderId = order.getOrderId();
//        this.user = new UserResponseDTO(order.getUser());
        this.userId = order.getUserId();
        this.itemId = order.getItemId();
        this.orderName = order.getOrderName();
    }
}
