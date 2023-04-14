package com.example.order.domin;

import lombok.Data;

import javax.persistence.*;



@Embeddable
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private int money;
}
