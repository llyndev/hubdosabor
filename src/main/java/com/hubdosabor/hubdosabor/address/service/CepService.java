package com.hubdosabor.hubdosabor.address.service;

import com.hubdosabor.hubdosabor.config.exception.custom.CepNotFoundException;
import com.hubdosabor.hubdosabor.config.exception.custom.ExternalServiceException;
import com.hubdosabor.hubdosabor.address.dto.response.CepResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CepService {

    private final WebClient viaCepWebClient;

    public CepResponse getCep(String cep) {
        CepResponse cepResponse = viaCepWebClient.get()
                .uri("/{cep}/json/", cep)
                .retrieve()
                .onStatus(HttpStatusCode::isError, response ->
                        Mono.error(new ExternalServiceException(
                                "Erro ao consultar CEP: " + response.statusCode()
                        ))
                )
                .bodyToMono(CepResponse.class)
                .block();

        if (cepResponse == null || cepResponse.erro()) {
            throw new CepNotFoundException("Erro ao consultar CEP: " + cep);
        }

        return cepResponse;
    }
}
