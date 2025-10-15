package com.hubdosabor.hubdosabor.users.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String cep,

        @NotBlank
        String number,

        @NotBlank
        String telephone,

        @NotBlank
        String password,

        @NotBlank
        String confirmPassword
) {
}
