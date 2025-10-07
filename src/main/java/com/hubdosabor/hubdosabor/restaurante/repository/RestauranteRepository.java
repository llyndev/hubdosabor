package com.hubdosabor.hubdosabor.restaurante.repository;

import com.hubdosabor.hubdosabor.restaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    Optional<Restaurante> findByNome(String nome);
}
