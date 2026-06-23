package com.demo.order.InterCommunication;

import com.demo.order.entity.User;
import jakarta.persistence.criteria.Order;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USER-SERVICE")
public interface UserService {

    @GetMapping("/users/{userid}")
    User getUserForOrder(@PathVariable Long userid);
}
