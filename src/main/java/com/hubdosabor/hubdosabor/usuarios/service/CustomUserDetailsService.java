package com.hubdosabor.hubdosabor.usuarios.service;

import com.hubdosabor.hubdosabor.usuarios.model.Usuario;
import com.hubdosabor.hubdosabor.usuarios.repository.UsuarioRepository;
import com.hubdosabor.hubdosabor.security.UserDeatilsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + email));
        return new UserDeatilsImpl(usuario);
    }
}
