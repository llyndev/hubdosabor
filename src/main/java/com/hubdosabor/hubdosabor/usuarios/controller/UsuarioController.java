package com.hubdosabor.hubdosabor.usuarios.controller;

import com.hubdosabor.hubdosabor.usuarios.dto.response.UsuarioResponse;
import com.hubdosabor.hubdosabor.usuarios.mapper.UsuarioMapper;
import com.hubdosabor.hubdosabor.usuarios.model.Usuario;
import com.hubdosabor.hubdosabor.usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @GetMapping
    public List<UsuarioResponse> getAll() {
        List<Usuario> usuario = usuarioService.getAll();
        return usuario.stream()
                .map(usuarioMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public UsuarioResponse getById(@PathVariable Long id) {
        return usuarioService.getById(id);
    }
}
