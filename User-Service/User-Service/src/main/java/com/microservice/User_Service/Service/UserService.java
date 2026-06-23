package com.microservice.User_Service.Service;


import com.microservice.User_Service.DTO.UserResponse;
import com.microservice.User_Service.Entity.Order;
import com.microservice.User_Service.Entity.User;
import com.microservice.User_Service.Exception.UserNotFoundException;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<UserResponse> getAllUsers();
    UserResponse userById(Long id) throws UserNotFoundException;
    User createUser(User user);
    User updateUser(User user,Long id);
    String deleteUser(Long id);
    User getOrdersByUserID(Long id) throws UserNotFoundException;

   // User patchUser(Map<String,Object> update,Long id);
}
