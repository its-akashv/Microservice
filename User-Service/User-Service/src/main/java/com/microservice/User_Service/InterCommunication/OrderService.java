package com.microservice.User_Service.InterCommunication;


import com.microservice.User_Service.Entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ORDER-SERVICE")
public interface OrderService {
    @GetMapping("/orders/user/{userId}")
    List<Order> getOrdersByUserID(@PathVariable long userId);
}
