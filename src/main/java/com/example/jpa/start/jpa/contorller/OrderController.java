package com.example.jpa.start.jpa.contorller;


import com.example.jpa.start.jpa.dto.OrderByUserResponseDTO;
import com.example.jpa.start.jpa.dto.OrderRequestDTO;
import com.example.jpa.start.jpa.dto.OrderResponseDTO;
import com.example.jpa.start.jpa.dto.OrderWithUserResponseDTO;
import com.example.jpa.start.jpa.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/jpa/api/v2")
public class OrderController {

    private final OrderService service;

    @PostMapping("/order")
    public OrderResponseDTO save(OrderRequestDTO requestDto) {
        return service.save(requestDto);
    }

    @GetMapping("/order/{userId}/{itemId}")
    public OrderResponseDTO select(@PathVariable Integer userId, @PathVariable Integer itemId) {
        return service.select(userId, itemId);
    }

    @GetMapping("/order/user/with/{userId}")
    public List<OrderWithUserResponseDTO> selectWithUser(@PathVariable Integer userId) {
        return service.selectWithUser(userId);
    }

    @GetMapping("/order/user/by/{userId}")
    public List<OrderByUserResponseDTO> selectByUser(@PathVariable Integer userId) {
        return service.selectByUser(userId);
    }

}

