package com.hubdosabor.hubdosabor.users.controller;

import com.hubdosabor.hubdosabor.users.dto.request.AuthRequest;
import com.hubdosabor.hubdosabor.users.dto.request.RegisterRequest;
import com.hubdosabor.hubdosabor.users.dto.response.AuthResponse;
import com.hubdosabor.hubdosabor.config.security.JwtUtil;
import com.hubdosabor.hubdosabor.users.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterService registerService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        registerService.registerUser(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User registered sucessfully!");
    }
}
