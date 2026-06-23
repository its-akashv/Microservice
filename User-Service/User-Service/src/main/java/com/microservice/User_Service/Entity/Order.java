package com.microservice.User_Service.Entity;

import com.microservice.User_Service.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    private long id;
    private long userId;
    private long productId;
    private int quantity;
    private double totalPrice;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;

}
