package com.microservice.User_Service.DTO;

import com.microservice.User_Service.Entity.Address;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {


    private String name;

    private String email;

    private String password;

    private String phone;

    private List<Address> address = new ArrayList<>();


}
