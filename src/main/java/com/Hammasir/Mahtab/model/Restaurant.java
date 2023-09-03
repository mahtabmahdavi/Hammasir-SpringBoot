package com.Hammasir.Mahtab.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "phone_number", length = 15, unique = true)
    private String phoneNumber;

    @Column(name = "address", length = 200)
    private String address;

    private List<FoodDTO> menu = new ArrayList<>();
}
