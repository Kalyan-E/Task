package com.example.order.service;


import com.example.order.domin.OrderModel;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Component
@Slf4j
public class OrderService {


    @Autowired
    private final OrderRepository orderRepository;

    public void addOrder(OrderModel orderModel) {
        orderRepository.save(orderModel);
    }

    public Optional<OrderModel> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<OrderModel> getOrders() {
        return orderRepository.findAll();
    }
}
