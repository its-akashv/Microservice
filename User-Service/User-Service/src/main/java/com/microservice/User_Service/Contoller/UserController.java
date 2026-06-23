package com.microservice.User_Service.Contoller;

import com.microservice.User_Service.DTO.UserResponse;
import com.microservice.User_Service.Entity.Order;
import com.microservice.User_Service.Entity.User;
import com.microservice.User_Service.Exception.UserNotFoundException;
import com.microservice.User_Service.Service.UserService;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;


    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;

    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getOrderByUserID(@PathVariable Long id) throws UserNotFoundException {
        return userService.getOrdersByUserID(id);
    }

    @GetMapping("/{id}")
    public UserResponse findUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.userById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable Long id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @PatchMapping("/{id}")
    public User patchUpdateUser(@RequestBody User user,@PathVariable Long id){
        userService.updateUser(user,id);
        return user;
    }
}
