package com.example.jpa.start.jpa.service;

import com.example.jpa.start.jpa.dto.UserRequestDTO;
import com.example.jpa.start.jpa.entity.User;
import com.example.jpa.start.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final UserRepository repository;

    public User join(UserRequestDTO requestDto) {
        return repository.save(requestDto.toEntity());
    }

    public User login(String userName) {
        return repository.findByUserName(userName);
    }
}
