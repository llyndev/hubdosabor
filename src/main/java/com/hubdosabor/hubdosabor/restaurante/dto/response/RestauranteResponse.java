package com.hubdosabor.hubdosabor.restaurante.dto.response;

import com.hubdosabor.hubdosabor.restaurante.model.Endereco;

public record RestauranteResponse(
        Long id,
        String nome,
        String descricao,
        Endereco endereco
) {
}
