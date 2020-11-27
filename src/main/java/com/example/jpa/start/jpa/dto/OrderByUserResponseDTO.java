package com.example.jpa.start.jpa.dto;

import com.example.jpa.start.jpa.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderByUserResponseDTO {

    private UserResponseDTO user;

    private ItemListResponseDTO item;

    private String orderName;

    public OrderByUserResponseDTO(Order entity) {
        this.user = new UserResponseDTO(entity.getUser());
        this.item = new ItemListResponseDTO(entity.getItem());
        this.orderName= entity.getOrderName();
    }
}

