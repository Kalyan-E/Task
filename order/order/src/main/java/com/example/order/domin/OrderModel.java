package com.example.order.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="t_order")
@Data
@RequiredArgsConstructor
public class OrderModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @OneToOne
   private User user;
   private Long productId;
   private Date orderTime;
   private OrderStatus orderStatus;

   public OrderModel(long productId, String productName, int stock, int price) {

   }
}
