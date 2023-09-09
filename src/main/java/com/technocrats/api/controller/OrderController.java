package com.technocrats.api.controller;

import com.technocrats.api.model.Order;
import com.technocrats.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(path = "/order/{orderId}",headers = "Accept=application/json")
    public ResponseEntity<Order> getOrder(@PathVariable String orderId){
        return new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }

    @PostMapping(path = "/order", headers = "Accept=application/json")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @PutMapping(path = "/order", headers = "Accept=application/json")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.updateOrder(order),HttpStatus.OK);
    }

    @DeleteMapping(path = "/order/{orderId}", headers = "Accept=application/json")
    public void deleteOrder(@PathVariable String orderId){
          orderService.deleteOrder(orderId);
    }


}
