package com.Hammasir.Mahtab.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id_seq")
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
