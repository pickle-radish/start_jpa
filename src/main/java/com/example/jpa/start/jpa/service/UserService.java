package com.example.jpa.start.jpa.service;

import com.example.jpa.start.jpa.dto.UserRequestDTO;
import com.example.jpa.start.jpa.dto.UserResponseDTO;
import com.example.jpa.start.jpa.entity.User;
import com.example.jpa.start.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    @Transactional
    public UserResponseDTO save(UserRequestDTO requestDto){
        return new UserResponseDTO(repository.save(requestDto.toEntity()));
    }


    @Transactional
    public UserResponseDTO update(Integer userId, UserRequestDTO requestDto) {
        User user = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + userId));
        user.setUserName(requestDto.getUserName());
        user.setClassNum(requestDto.getClassNum());

        return new UserResponseDTO(user);
    }

    @Transactional
    public void delete(Integer userId) {
        repository.deleteById(userId);
    }
}
