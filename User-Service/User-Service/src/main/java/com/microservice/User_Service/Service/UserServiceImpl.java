package com.microservice.User_Service.Service;

import com.microservice.User_Service.DTO.UserResponse;
import com.microservice.User_Service.Entity.Address;
import com.microservice.User_Service.Entity.Order;
import com.microservice.User_Service.Entity.User;
import com.microservice.User_Service.Exception.UserNotFoundException;
import com.microservice.User_Service.InterCommunication.OrderService;
import com.microservice.User_Service.Mapper.UserMapper;
import com.microservice.User_Service.Repository.UserRepository;
import com.microservice.User_Service.Enums.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private OrderService orderService;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, OrderService orderService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.orderService = orderService;
        this.userMapper = userMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User user : users) {
            userResponseList.add(userMapper.toResponse(user));
        }
        return userResponseList;
    }

    @Override
    public UserResponse userById(Long id) throws UserNotFoundException{
        User user =userRepository.findById(id).orElseThrow(()-> new UserNotFoundException());
        return userMapper.toResponse(user);
    }

    @Override
    public User createUser(User user) {
        for (Address address : user.getAddress()) {
            address.setUser(user);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       User user1= userRepository.save(user);
       return user1;
    }

    @Override
    public User updateUser(User user, Long id) {

        User user1 = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));


        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());
        user1.setPassword(user.getPassword());
        user1.setUpdatedAt(LocalDateTime.now());

        if (user.getRole() != null) {
            user1.setRole(Role.USER);
        }


        if (user.getAddress() != null) {

            List<Address> updatedAddresses = new ArrayList<>();

            for (Address addr : user.getAddress()) {

                Address newAddr = new Address();
                newAddr.setStreet(addr.getStreet());
                newAddr.setCity(addr.getCity());
                newAddr.setState(addr.getState());
                newAddr.setPincode(addr.getPincode());

                newAddr.setUser(user1);
                updatedAddresses.add(newAddr);
            }

            user1.getAddress().clear();
            user1.getAddress().addAll(updatedAddresses);
        }

        return userRepository.save(user1);
    }

    @Override
    public String deleteUser(Long id) {
         userRepository.deleteById(id);
         return "User Deleted Successfully";
    }

    @Override
    public User getOrdersByUserID(Long id) throws UserNotFoundException{
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User Doesn't Exist with Id : " +id));
        List<Order> orders = orderService.getOrdersByUserID(id);
        user.setOrders(orders);
        return user;
    }


//    @Override
//    public User patchUser(Map<String, Object> update, Long id) {
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User Not Found"));
//
//        if (update.containsKey("name")) {
//            user.setName((String) update.get("name"));
//        }
//
//        if (update.containsKey("email")) {
//            user.setEmail((String) update.get("email"));
//        }
//
//        if (update.containsKey("phone")) {
//            user.setPhone((String) update.get("phone"));
//        }
//
//        if (update.containsKey("password")) {
//            user.setPassword((String) update.get("password"));
//        }
//
//        if (update.containsKey("addresses")) {
//
//            List<Map<String, Object>> addressList =
//                    (List<Map<String, Object>>) update.get("addresses");
//
//            List<Address> updatedAddresses = new ArrayList<>();
//
//            for (Map<String, Object> addrMap : addressList) {
//
//                Address address = new Address();
//
//                if (addrMap.get("street") != null)
//                    address.setStreet(addrMap.get("street").toString());
//
//                if (addrMap.get("city") != null)
//                    address.setCity(addrMap.get("city").toString());
//
//                if (addrMap.get("state") != null)
//                    address.setState(addrMap.get("state").toString());
//
//
//                address.setUser(user);
//
//                updatedAddresses.add(address);
//            }
//
//            user.getAddress().clear();
//            user.getAddress().addAll(updatedAddresses);
//        }
//
//        return userRepository.save(user);
//    }


}
