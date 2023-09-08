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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foods_id")
    @SequenceGenerator(name = "foods_id", sequenceName = "foods_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<RestaurantFoodMapping> foods;

//    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
//    private List<Cart> carts;
}
