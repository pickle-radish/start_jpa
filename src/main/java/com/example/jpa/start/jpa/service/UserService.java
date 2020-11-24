package com.example.jpa.start.jpa.service;

import com.example.jpa.start.jpa.dto.UserRequestDTO;
import com.example.jpa.start.jpa.dto.UserResponseDTO;
import com.example.jpa.start.jpa.entity.User;
import com.example.jpa.start.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        User user = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다 id=" + userId));
        user.setUserName(requestDto.getUserName());
        user.setClassNum(requestDto.getClassNum());

        return new UserResponseDTO(user);
    }

    @Transactional
    public void delete(Integer userId) {
        repository.deleteById(userId);
    }

    public UserResponseDTO select(Integer userId) {
//        User user = repository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다 id=" + userId));
        User user = repository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다 id=" + userId));
        return new UserResponseDTO(user);
    }

    public List<UserResponseDTO> selectClassNum(String classNum) {
        List<User> list = repository.findAllByClassNum(classNum);
        return list.stream().map(o -> new UserResponseDTO(o)).collect(Collectors.toList());
    }

    public Page<UserResponseDTO> selectAll(Pageable pageable) {
        Page<User> list = repository.findAll(pageable);
        List<UserResponseDTO> responseDtoList = list.stream().map(o -> new UserResponseDTO(o)).collect(Collectors.toList());

        return new PageImpl<>(null, pageable, list.getTotalElements());
    }
}
