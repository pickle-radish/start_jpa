package com.example.jpa.start.jpa.service;


import com.example.jpa.start.jpa.dto.OrderRequestDTO;
import com.example.jpa.start.jpa.dto.OrderResponseDTO;
import com.example.jpa.start.jpa.entity.User;
import com.example.jpa.start.jpa.repository.OrderRepository;
import com.example.jpa.start.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final UserRepository userRepository;

    public OrderResponseDTO save(OrderRequestDTO requestDto) {
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다"));
        return new OrderResponseDTO(repository.save(requestDto.toEntity(user)));
    }
}
