package com.demo.order.service;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.order.dto.OrderRequest;
import com.demo.order.dto.OrderResponse;
import com.demo.order.entity.Order;
import com.demo.order.mapper.OrderMapper;
import com.demo.order.orderEnum.OrderStatus;
import com.demo.order.repository.OrderRepository;


@Service
public class OrderImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderImpl(
            OrderRepository orderRepository,
            OrderMapper orderMapper) {

        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    // create order
    public OrderResponse createOrder(OrderRequest request){

        Order order = orderMapper.toEntity(request);
        order.setOrderStatus(OrderStatus.CREATED);
        order.setOrderDate(new Date());

        Order saveOrder = orderRepository.save(order);
        return orderMapper.toResponse(saveOrder);

    }

    //get by id
    public OrderResponse getOrderById(long id){
        
        Order order = orderRepository.getById(id);
        return orderMapper.toResponse(order);

     }

    //get all order 
    public List<OrderResponse> getAllOrder(){

        return orderRepository.findAll()
                .stream()
                .map(orderMapper:: toResponse)
                .toList();

    }

    //delete by id
    public void deleteOrder(long id){

        if(!orderRepository.existsById(id)){
            throw new RuntimeException("Order not found by id:"+id);
        }
            orderRepository.deleteById(id);

        }

     }
    

