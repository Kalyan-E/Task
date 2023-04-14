package com.example.order.controller;

import com.example.order.domin.OrderModel;
import com.example.order.dto.ProductDto;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor

public class OrderController {

    @Autowired
    private final OrderService orderService;
    @Autowired
    private final RestTemplate restTemplate;


    private String apiKey;
    @Autowired
    private final OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity addProducts(@RequestBody List<OrderModel> orderModel)
    {
        orderService.addOrder(orderModel.get(0));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @GetMapping("/all")
      public List<OrderModel> getOrders() {
      return orderService.getOrders();
}

    @GetMapping("products/{productId}")
    public ProductDto getProducts(@PathVariable("productId") Long productId) {
        ProductDto productDto = restTemplate.getForObject("http://localhost:8080/products/" + productId + "?api_key=" +  apiKey, ProductDto.class);
        return new ProductDto(productDto.getProductId(), productDto.getProductName(), productDto.getStock(),productDto.getPrice());
    }

}

