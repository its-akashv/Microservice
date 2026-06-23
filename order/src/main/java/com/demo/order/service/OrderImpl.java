package com.demo.order.service;


import java.util.List;

import com.demo.order.InterCommunication.UserService;
import com.demo.order.entity.User;
import org.springframework.stereotype.Service;
import com.demo.order.entity.Order;
import com.demo.order.orderEnum.OrderStatus;
import com.demo.order.repository.OrderRepository;


@Service
public class OrderImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;


    public OrderImpl(
            OrderRepository orderRepository, UserService userService
    ) {

        this.orderRepository = orderRepository;

        this.userService = userService;
    }

    // create order
    public Order createOrder(Order order){


        order.setOrderStatus(OrderStatus.CREATED);
        order.onOrder();
        Order saveOrder = orderRepository.save(order);
        return saveOrder;

    }

    //get by id
    public Order getOrderById(long id){
        
        Order order = orderRepository.getById(id);
        return order;

     }

    //get all order 
    public List<Order> getAllOrder(){

        return orderRepository.findAll()
                .stream()
                .toList();

    }

    //delete by id
    public void deleteOrder(long id){

        if(!orderRepository.existsById(id)){
            throw new RuntimeException("Order not found by id:"+id);
        }
            orderRepository.deleteById(id);

        }

    @Override
    public List<Order> getOrderByUserId(long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order getUserDataforOrder(long orderid) {
        Order order=  orderRepository.getById(orderid);
        //System.out.println(order.getUserId());
        User user =userService.getUserForOrder(order.getUserId());
        order.setUser(user);

        return order;
    }

}
    

