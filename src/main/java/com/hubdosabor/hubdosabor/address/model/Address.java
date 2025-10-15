package com.hubdosabor.hubdosabor.address.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(name = "end_cep", nullable = false)
    private String cep;

    @Column(name = "end_logradouro", nullable = false)
    private String logradouro;

    @Column(name = "end_numero", nullable = false)
    private String numero;

    @Column(name = "end_complemento")
    private String complemento;

    @Column(name = "end_bairro", nullable = false)
    private String bairro;

    @Column(name = "end_localidade", nullable = false)
    private String localidade;

    @Column(name = "end_uf", nullable = false)
    private String uf;
}
