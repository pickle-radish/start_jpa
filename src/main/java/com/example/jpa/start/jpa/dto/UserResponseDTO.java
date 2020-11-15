package com.example.jpa.start.jpa.dto;

import com.example.jpa.start.jpa.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class UserResponseDTO {

    private Integer userId;
    private String classNum;
    private String userName;

    public UserResponseDTO(User user) {
        this.userId = user.getUserId();
        this.classNum = user.getClassNum();
        this.userName = user.getUserName();
    }
}
