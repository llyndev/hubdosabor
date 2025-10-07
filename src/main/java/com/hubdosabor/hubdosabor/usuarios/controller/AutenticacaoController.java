package com.hubdosabor.hubdosabor.usuarios.controller;

import com.hubdosabor.hubdosabor.usuarios.dto.request.AutenticacaoRequest;
import com.hubdosabor.hubdosabor.usuarios.dto.request.RegistroRequest;
import com.hubdosabor.hubdosabor.usuarios.dto.response.AutenticacaoResponse;
import com.hubdosabor.hubdosabor.usuarios.security.JwtUtil;
import com.hubdosabor.hubdosabor.usuarios.service.RegistrarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticacaoController {

    private final RegistrarService registrarService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/logar")
    public ResponseEntity<AutenticacaoResponse> logar(@RequestBody AutenticacaoRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.senha())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AutenticacaoResponse(token));
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@Valid @RequestBody RegistroRequest request) {
        registrarService.registrarUsuario(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario registrado com sucesso!");
    }
}
