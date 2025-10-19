package com.hubdosabor.hubdosabor.restaurant.controller;

import com.hubdosabor.hubdosabor.config.security.UserDeatilsImpl;
import com.hubdosabor.hubdosabor.restaurant.dto.request.MenuRequest;
import com.hubdosabor.hubdosabor.restaurant.dto.response.MenuResponse;
import com.hubdosabor.hubdosabor.restaurant.mapper.MenuMapper;
import com.hubdosabor.hubdosabor.restaurant.model.Menu;
import com.hubdosabor.hubdosabor.restaurant.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;
    private final MenuMapper menuMapper;

    @GetMapping
    public ResponseEntity<List<MenuResponse>> getAll() {
        return ResponseEntity.ok(menuService.getAll());
    }

    @PostMapping("/{id}")
    public ResponseEntity<MenuResponse> addMenu(@PathVariable Long id, @RequestBody MenuRequest request, @AuthenticationPrincipal UserDeatilsImpl userDeatils) {
        return ResponseEntity.ok(menuService.addMenu(id, request, userDeatils.getUsername()));
    }
}
