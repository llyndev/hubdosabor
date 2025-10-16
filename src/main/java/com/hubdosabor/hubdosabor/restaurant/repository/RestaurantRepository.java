package com.hubdosabor.hubdosabor.restaurant.repository;

import com.hubdosabor.hubdosabor.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByNameContainingIgnoreCase(String name);

    @Query("SELECT r FROM Restaurant  r JOIN FETCH r.menus WHERE r.id = :id")
    Optional<Restaurant> findByIdWithMenu(@Param("id") Long id);
}
