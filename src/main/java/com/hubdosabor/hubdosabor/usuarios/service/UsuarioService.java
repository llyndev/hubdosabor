package com.hubdosabor.hubdosabor.usuarios.service;

import com.hubdosabor.hubdosabor.usuarios.dto.response.UsuarioResponse;
import com.hubdosabor.hubdosabor.usuarios.mapper.UsuarioMapper;
import com.hubdosabor.hubdosabor.usuarios.model.Usuario;
import com.hubdosabor.hubdosabor.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public UsuarioResponse getById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDTO)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado"));
    }
}
