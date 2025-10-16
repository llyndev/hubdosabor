package com.hubdosabor.hubdosabor.address.mapper;

import com.hubdosabor.hubdosabor.address.dto.response.CepResponse;
import com.hubdosabor.hubdosabor.address.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(CepResponse cepResponse, String number) {
        if (cepResponse == null) {
            return null;
        }

        Address address = new Address();

        address.setCep(cepResponse.cep());
        address.setLogradouro(cepResponse.logradouro());
        address.setComplemento(cepResponse.complemento());
        address.setBairro(cepResponse.bairro());
        address.setNumero(number);
        address.setLocalidade(cepResponse.cidade());
        address.setUf(cepResponse.estado());

        return address;
    }
}
