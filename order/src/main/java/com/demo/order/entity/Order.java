package com.demo.order.entity;
import java.time.LocalDateTime;

import com.demo.order.orderEnum.OrderStatus;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name="customer_order")

public class Order{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    private long userId;
    private long productId;
    private int quantity;
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Transient
    private User user;
    private LocalDateTime orderDate;

    @PrePersist
    public void onOrder() {
        this.orderDate = LocalDateTime.now();
    }
}