package com.hubdosabor.hubdosabor.users.service;

import com.hubdosabor.hubdosabor.users.dto.request.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    void registerUser(RegisterRequest request);
}
