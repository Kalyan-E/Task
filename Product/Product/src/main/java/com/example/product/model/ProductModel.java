package com.example.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_product")
public class ProductModel {
    @Id
    @GeneratedValue
    private long id;
    private String productName;
    private int stock;
    private int price;
}
