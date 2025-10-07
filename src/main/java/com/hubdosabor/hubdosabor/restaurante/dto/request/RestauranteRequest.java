package com.hubdosabor.hubdosabor.restaurante.dto.request;

import com.hubdosabor.hubdosabor.restaurante.model.Endereco;

public record RestauranteRequest(
        String nome,
        String descricao,
        Endereco endereco
) {
}
