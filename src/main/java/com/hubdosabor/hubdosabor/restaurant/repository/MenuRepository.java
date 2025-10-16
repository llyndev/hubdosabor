package com.hubdosabor.hubdosabor.restaurant.repository;

import com.hubdosabor.hubdosabor.restaurant.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
