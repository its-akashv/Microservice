package com.demo.order.dto;

import java.util.Date;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class OrderResponse {
    private long id;
    private long userId;
    private long productId;
    private int quantity;
    private double totalPrice;
    private Enum OrderStatus;
    private Date orderDate;
}
