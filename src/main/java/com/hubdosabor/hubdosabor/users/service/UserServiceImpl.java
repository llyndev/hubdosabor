package com.hubdosabor.hubdosabor.users.service;

import com.hubdosabor.hubdosabor.users.dto.request.RegisterRequest;
import com.hubdosabor.hubdosabor.users.model.User;
import com.hubdosabor.hubdosabor.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(RegisterRequest request) {
        if (userRepository.findByEmailContainingIgnoreCase(request.email()).isPresent()) {
            throw new IllegalStateException("E-mail already exists.");
        }

        if (!request.password().equals(request.confirmPassword())) {
            throw new IllegalStateException("Invalid credentials.");
        }

        User user = new User();
        user.setName(request.name());
        user.setEmail(request.email());
        user.setTelephone(request.telephone());
        user.setRole(User.Role.USER);
        user.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(user);
    }
}
