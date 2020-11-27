package com.example.jpa.start.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
//@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    private String classNum;

    @Column(name = "user_name", unique = true)
    private String userName;
    private String phone;

}
