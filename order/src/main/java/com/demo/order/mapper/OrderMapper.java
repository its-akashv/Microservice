package com.demo.order.mapper;
import com.demo.order.entity.Order;
import org.mapstruct.Mapper;
import com.demo.order.dto.OrderRequest;
import com.demo.order.dto.OrderResponse;

@Mapper(componentModel ="spring")
public interface OrderMapper {

  Order toEntity(OrderRequest request);
    OrderResponse toResponse(Order order);

}
