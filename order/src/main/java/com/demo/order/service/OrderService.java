package com.demo.order.service;
import java.util.List;

import com.demo.order.dto.OrderRequest;
import com.demo.order.dto.OrderResponse;

public interface OrderService {
    
    OrderResponse createOrder(OrderRequest request);
    OrderResponse getOrderById(long id);
    List<OrderResponse> getAllOrder();
    void deleteOrder(long id);

}
