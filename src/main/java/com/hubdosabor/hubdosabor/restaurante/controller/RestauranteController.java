package com.hubdosabor.hubdosabor.restaurante.controller;

import com.hubdosabor.hubdosabor.restaurante.dto.request.RestauranteRequest;
import com.hubdosabor.hubdosabor.restaurante.dto.response.RestauranteResponse;
import com.hubdosabor.hubdosabor.restaurante.mapper.RestauranteMapper;
import com.hubdosabor.hubdosabor.restaurante.model.Restaurante;
import com.hubdosabor.hubdosabor.restaurante.service.RestauranteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteService restauranteService;
    private final RestauranteMapper restauranteMapper;

    @PostMapping
    public ResponseEntity<RestauranteResponse> criarRestaurante(@RequestBody RestauranteRequest request) {
        return ResponseEntity.ok(restauranteService.criarRestaurante(request));
    }

    @GetMapping
    public ResponseEntity<List<RestauranteResponse>> getAllRestaurantes() {
        List<Restaurante> restaurante = restauranteService.getAllRestaurante();
        return ResponseEntity.ok(restaurante.stream()
                .map(restauranteMapper::toDTO)
                .toList());
    }

}
