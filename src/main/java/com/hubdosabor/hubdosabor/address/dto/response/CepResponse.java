package com.hubdosabor.hubdosabor.address.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;

public record CepResponse(
        @JsonProperty("cep")
        String cep,

        @JsonProperty("logradouro")
        String logradouro,

        @JsonProperty("complemento")
        String complemento,

        @JsonProperty("bairro")
        String bairro,

        @JsonProperty("localidade")
        String cidade,

        @JsonProperty("uf") @Size(min = 2, max = 2)
        String estado,

        boolean erro


) {
}
