package com.hubdosabor.hubdosabor.restaurant.model;

import com.hubdosabor.hubdosabor.address.model.Address;
import com.hubdosabor.hubdosabor.users.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menus;
}
