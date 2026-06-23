package com.demo.order.controller;

import java.util.List;

import com.demo.order.entity.Order;
import com.demo.order.orderEnum.OrderStatus;
import com.demo.order.service.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.demo.order.dto.OrderRequest;
import com.demo.order.dto.OrderResponse;
import com.demo.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {


    private final OrderImpl orderderService;

    public OrderController(OrderImpl orderderService) {
        this.orderderService = orderderService;
    }


    @PostMapping
    public Order createOrder(@RequestBody Order order){

        if(order.getOrderStatus()==null)
        {
            order.setOrderStatus(OrderStatus.CREATED);
        }
        return orderderService.createOrder(order);
    } 


    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderderService.getOrderById(id);
    }


    @GetMapping("/allOrders")
    public List<Order> getAllOrders(){
        return orderderService.getAllOrder();
    }

    @GetMapping("/user/{userId}")
    public List<Order> getAllOrdersByUserId(@PathVariable long userId){
        return orderderService.getOrderByUserId(userId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderderService.deleteOrder(id);
        return "Order deleted";
    }

    @GetMapping("/orderData/{orderid}")
    public Order getUserdata(@PathVariable Long orderid){
        return orderderService.getUserDataforOrder(orderid);
    }



}
