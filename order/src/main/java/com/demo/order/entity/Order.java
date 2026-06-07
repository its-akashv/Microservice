package com.demo.order.entity;
import java.util.Date;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name="Order")

public class Order{
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    private long userId;
    private long productId;
    private int quantity;
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private Enum OrderStatus;
    private Date orderDate;
}