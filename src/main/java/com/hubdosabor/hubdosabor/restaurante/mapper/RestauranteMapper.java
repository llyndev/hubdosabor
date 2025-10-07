package com.hubdosabor.hubdosabor.restaurante.mapper;

import com.hubdosabor.hubdosabor.restaurante.dto.request.RestauranteRequest;
import com.hubdosabor.hubdosabor.restaurante.dto.response.RestauranteResponse;
import com.hubdosabor.hubdosabor.restaurante.model.Restaurante;
import org.springframework.stereotype.Component;

@Component
public class RestauranteMapper {

    public RestauranteResponse toResponse(Restaurante restaurante) {
        return new RestauranteResponse(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getDescricao(),
                restaurante.getEndereco()
        );
    }

    public Restaurante toEntity(RestauranteRequest request) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(request.nome());
        restaurante.setDescricao(request.descricao());
        restaurante.setEndereco(request.endereco());
        return restaurante;
    }

    public RestauranteResponse toDTO(Restaurante restaurante) {
        if (restaurante == null) return null;

        return new RestauranteResponse(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getDescricao(),
                restaurante.getEndereco()
        );
    }
}
