package com.hubdosabor.hubdosabor.restaurant.repository;

import com.hubdosabor.hubdosabor.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByNameContainingIgnoreCase(String name);
}
