package com.Hammasir.springboot.model.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestaurantDTO {
    private String name;
    private String phoneNumber;
    private String address;
}
