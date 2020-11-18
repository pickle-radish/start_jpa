package com.example.jpa.start.jpa.contorller;


import com.example.jpa.start.jpa.dto.OrderRequestDTO;
import com.example.jpa.start.jpa.dto.OrderResponseDTO;
import com.example.jpa.start.jpa.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jpa/api/v2")
public class OrderController {

    private final OrderService service;

    @PostMapping("/order")
    public OrderResponseDTO save(OrderRequestDTO requestDto) {
        return service.save(requestDto);
    }
}
