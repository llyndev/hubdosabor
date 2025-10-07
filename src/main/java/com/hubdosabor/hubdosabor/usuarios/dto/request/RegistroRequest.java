package com.hubdosabor.hubdosabor.usuarios.dto.request;

public record RegistroRequest(
        String nome,
        String email,
        String telefone,
        String senha,
        String confirmarSenha
) {
}
