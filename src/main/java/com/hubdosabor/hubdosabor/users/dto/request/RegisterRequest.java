package com.hubdosabor.hubdosabor.users.dto.request;

public record RegisterRequest(
        String name,
        String email,
        String telephone,
        String password,
        String confirmPassword
) {
}
