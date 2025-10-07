package com.hubdosabor.hubdosabor.restaurante.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_restaurante")
    private String nome;

    @Column(name = "descricao_restaurante")
    private String descricao;

    @Column(name = "endereco")
    private Endereco endereco;
}
