package com.example.jpa.start.jpa.dto;

import com.example.jpa.start.jpa.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String classNum;
    private String userName;
//    private String phone;
    public User toEntity() {
        return User.builder()
                .classNum(classNum)
                .userName(userName)
//                .phone(phone)
                .build();
    }
}
