package com.example.jpa.start.jpa.service;


import com.example.jpa.start.jpa.dto.OrderRequestDTO;
import com.example.jpa.start.jpa.dto.OrderResponseDTO;
import com.example.jpa.start.jpa.dto.OrderWithUserResponseDTO;
import com.example.jpa.start.jpa.entity.Order;
import com.example.jpa.start.jpa.repository.OrderRepository;
import com.example.jpa.start.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final UserRepository userRepository;

    public OrderResponseDTO save(OrderRequestDTO requestDto) {
//        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다"));
//        return new OrderResponseDTO(repository.save(requestDto.toEntity(user)));
        return new OrderResponseDTO(repository.save(requestDto.toEntity()));
    }

    public OrderResponseDTO select(Integer userId) {
        Order order = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다"));
        return new OrderResponseDTO(order);
    }

    public List<OrderWithUserResponseDTO> selectByUserId(Integer userId) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다"));
        List<Order> list = repository.findAllByUserId(userId);
        return list.stream().map(o -> new OrderWithUserResponseDTO(o)).collect(Collectors.toList());
    }

}
