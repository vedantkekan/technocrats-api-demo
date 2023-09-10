package com.techflow.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_tbl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Order {

    @Id
    String orderId;
    String orderDate;
    BigDecimal orderPrice;


    public Order() {
    }

    public Order(String orderId, String orderDate, BigDecimal orderPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
