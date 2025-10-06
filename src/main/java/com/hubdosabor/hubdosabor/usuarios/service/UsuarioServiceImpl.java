package com.hubdosabor.hubdosabor.usuarios.service;

import com.hubdosabor.hubdosabor.usuarios.dto.request.UsuarioRequest;
import com.hubdosabor.hubdosabor.usuarios.model.Usuario;
import com.hubdosabor.hubdosabor.usuarios.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements RegistrarService{

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public void registrarUsuario(UsuarioRequest request) {
        if (usuarioRepository.findByEmail(request.email()).isPresent()) {
            throw new IllegalStateException("E-mail já existe");
        }

        if (!request.senha().equals(request.confirmarSenha())) {
            throw new IllegalStateException("Alguma credencial invalida.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setTelefone(request.telefone());
        usuario.setRole(Usuario.Role.USER);
        usuario.setSenha(passwordEncoder.encode(request.senha()));

        usuarioRepository.save(usuario);
    }
}
