package com.hubdosabor.hubdosabor.usuarios.dto.response;

import com.hubdosabor.hubdosabor.usuarios.model.Usuario;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        Usuario.Role role
) {
}
