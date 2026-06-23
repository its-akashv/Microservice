package com.demo.order.controller;

import com.demo.order.entity.Order;
import com.demo.order.repository.OrderRepository;
import com.demo.order.service.OrderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductContoller {


    private final OrderImpl  orderImpl;
    public ProductContoller(OrderImpl orderImpl) {
        this.orderImpl = orderImpl;
    }

    @GetMapping("/allProductDetails")
    public Map<Long,Integer> getProductDetails()
    {
        Map<Long,Integer> map = new LinkedHashMap<>();
       List<Order> allOrder= orderImpl.getAllOrder();
       for (Order order : allOrder) {
           map.put(order.getProductId(),  order.getQuantity());
       }
        return map;
    }

}
