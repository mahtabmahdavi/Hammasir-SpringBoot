package com.Hammasir.Mahtab.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", length = 30, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "phone_number", length = 15, unique = true)
    private String phoneNumber;

    @Column(name = "address", length = 200)
    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient
    private int age;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private String roles;

    private List<Order> orders = new ArrayList<>();
}
