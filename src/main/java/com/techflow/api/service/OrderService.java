package com.techflow.api.service;

import com.techflow.api.model.Order;
import com.techflow.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService{

    @Autowired
    OrderRepository orderRepository;

    public Order getOrder(String orderId) {
        return orderRepository.getById(orderId);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }
}
