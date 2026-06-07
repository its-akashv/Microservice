package com.microservice.User_Service.Contoller;

import com.microservice.User_Service.Entity.User;
import com.microservice.User_Service.Service.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
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
