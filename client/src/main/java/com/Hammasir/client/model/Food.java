package com.Hammasir.client.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food {
    private String name;
    private Long price;
}
