package com.hubdosabor.hubdosabor.restaurante.service;

import com.hubdosabor.hubdosabor.restaurante.dto.request.RestauranteRequest;
import com.hubdosabor.hubdosabor.restaurante.dto.response.RestauranteResponse;
import com.hubdosabor.hubdosabor.restaurante.mapper.RestauranteMapper;
import com.hubdosabor.hubdosabor.restaurante.model.Restaurante;
import com.hubdosabor.hubdosabor.restaurante.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteMapper restauranteMapper;

    public RestauranteResponse criarRestaurante(RestauranteRequest request) {
        if (restauranteRepository.findByNome(request.nome()).isPresent()) {
            throw new IllegalStateException("Já existe um estabelecimento com este nome");
        }

        Restaurante restaurante = restauranteMapper.toEntity(request);

        Restaurante restauranteSalvo = restauranteRepository.save(restaurante);

        return restauranteMapper.toResponse(restauranteSalvo);
    }

    public List<Restaurante> getAllRestaurante() {
        return restauranteRepository.findAll();
    }

}
