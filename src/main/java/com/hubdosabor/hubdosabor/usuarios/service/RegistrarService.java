package com.hubdosabor.hubdosabor.usuarios.service;

import com.hubdosabor.hubdosabor.usuarios.dto.request.RegistroRequest;
import org.springframework.stereotype.Service;

@Service
public interface RegistrarService {

    void registrarUsuario(RegistroRequest request);
}
