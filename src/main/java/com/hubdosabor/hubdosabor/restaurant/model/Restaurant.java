package com.hubdosabor.hubdosabor.restaurant.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_restaurant")
    private String name;

    @Column(name = "description_restaurant")
    private String description;

    @Column(name = "address")
    private Address address;
}
