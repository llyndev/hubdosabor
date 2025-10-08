package com.hubdosabor.hubdosabor.users.dto.request;

public record AuthRequest(
        String email,
        String password
) {}
