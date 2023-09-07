package com.Hammasir.springboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foods_id_seq")
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "firstFood", cascade = CascadeType.ALL)
    private List<Menu> menus;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<Cart> carts;
}
