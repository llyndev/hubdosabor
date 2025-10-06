package com.hubdosabor.hubdosabor.usuarios.controller;

import com.hubdosabor.hubdosabor.usuarios.dto.request.UsuarioRequest;
import com.hubdosabor.hubdosabor.usuarios.service.RegistrarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrar")
@RequiredArgsConstructor
public class RegistrarController {

    private final RegistrarService registrarService;

    @PostMapping
    public ResponseEntity<String> registrar(@Valid @RequestBody UsuarioRequest request) {
        registrarService.registrarUsuario(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario registrado com sucesso!");
    }
}
