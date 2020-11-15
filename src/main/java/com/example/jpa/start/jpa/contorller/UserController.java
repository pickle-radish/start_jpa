package com.example.jpa.start.jpa.contorller;

import com.example.jpa.start.jpa.dto.UserRequestDTO;
import com.example.jpa.start.jpa.dto.UserResponseDTO;
import com.example.jpa.start.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/jpa/api/v2")
public class UserController {

    private final UserService service;

    @PostMapping("/user")
    public UserResponseDTO save(UserRequestDTO requestDto) {
        return service.save(requestDto);
    }
}
