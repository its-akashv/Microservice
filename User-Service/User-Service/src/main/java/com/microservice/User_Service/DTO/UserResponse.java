package com.microservice.User_Service.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.microservice.User_Service.Entity.Address;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonPropertyOrder({"name", "email", "phone", "address"})
public class UserResponse {


    private String name;

    private String email;

    private String phone;

    private List<Address> address = new ArrayList<>();


}
