package com.hubdosabor.hubdosabor.usuarios.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "usuario_role")
    private Role role;

    private boolean active = true;
    private boolean blocked = false;
    private LocalDate dateExpirationAccount;

    public enum Role {
        ADMIN,
        OWNER,
        USER
    }
}
