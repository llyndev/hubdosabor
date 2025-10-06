package com.hubdosabor.hubdosabor.usuarios.mapper;

import com.hubdosabor.hubdosabor.usuarios.dto.response.UsuarioResponse;
import com.hubdosabor.hubdosabor.usuarios.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponse toDTO(Usuario usuario) {
        if (usuario == null) return null;

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getRole()
        );
    }

}
