package com.demo.order.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    private String name;

    private String email;

    private String phone;

    private List<Address> address = new ArrayList<>();
}
