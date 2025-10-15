package com.hubdosabor.hubdosabor.users.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_role")
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
