package com.demo.order.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.order.dto.OrderRequest;
import com.demo.order.dto.OrderResponse;
import com.demo.order.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderderService;

    public OrderController(OrderService orderService){
        this.orderderService = orderService;
    }

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest request){

        return orderderService.createOrder(request);
    } 


    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id){
        return orderderService.getOrderById(id);
    }


    @GetMapping("/allOrders")
    public List<OrderResponse> getAllOrders(){
        return orderderService.getAllOrder();
    }


    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderderService.deleteOrder(id);
        return "Order deleted";
    }

}
