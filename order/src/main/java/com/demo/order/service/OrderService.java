package com.demo.order.service;
import java.util.List;

import com.demo.order.dto.OrderRequest;
import com.demo.order.dto.OrderResponse;
import com.demo.order.entity.Order;

public interface OrderService {
    
    Order createOrder(Order request);
    Order getOrderById(long id);
    List<Order> getAllOrder();
    void deleteOrder(long id);
    List<Order> getOrderByUserId(long userId);
    Order getUserDataforOrder(long userId);


}
