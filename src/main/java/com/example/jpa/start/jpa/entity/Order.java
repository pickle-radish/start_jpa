package com.example.jpa.start.jpa.entity;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_table")
public class Order {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer orderId;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    private String orderName;

}
