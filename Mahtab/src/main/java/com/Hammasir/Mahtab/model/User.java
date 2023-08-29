package com.Hammasir.Mahtab.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
public class User{
    private String username;
    private String password;
    private String roles;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Order> orders = new ArrayList<>();

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
