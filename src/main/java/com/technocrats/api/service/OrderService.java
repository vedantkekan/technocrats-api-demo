package com.technocrats.api.service;

import com.technocrats.api.model.Order;
import com.technocrats.api.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService{

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
