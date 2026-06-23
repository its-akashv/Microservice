package com.microservice.User_Service.Mapper;

import com.microservice.User_Service.DTO.UserResponse;
import com.microservice.User_Service.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setAddress(user.getAddress());
        userResponse.setPhone(user.getPhone());

        return userResponse;
    }
}
