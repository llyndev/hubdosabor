package com.hubdosabor.hubdosabor.restaurant.model;

import com.hubdosabor.hubdosabor.users.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    private Status status;

    @ManyToOne
    private User user;

    @ManyToOne
    private Restaurant restaurant;

    public enum Status {
        CONFIRMORDER,
        CANCELORDER,
        PREPARING,
        DELIVERYROUTE

    }

}
