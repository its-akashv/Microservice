package com.microservice.User_Service.Service;


import com.microservice.User_Service.Entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAllUsers();
    User userById(Long id);
    User createUser(User user);
    User updateUser(User user,Long id);
    String deleteUser(Long id);
   // User patchUser(Map<String,Object> update,Long id);
}
