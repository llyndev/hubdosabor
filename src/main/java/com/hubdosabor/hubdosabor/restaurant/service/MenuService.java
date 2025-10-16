package com.hubdosabor.hubdosabor.restaurant.service;

import com.hubdosabor.hubdosabor.config.exception.custom.AccessDeniedException;
import com.hubdosabor.hubdosabor.config.exception.custom.ResourceNotFoundException;
import com.hubdosabor.hubdosabor.restaurant.dto.request.MenuRequest;
import com.hubdosabor.hubdosabor.restaurant.dto.response.MenuResponse;
import com.hubdosabor.hubdosabor.restaurant.mapper.MenuMapper;
import com.hubdosabor.hubdosabor.restaurant.model.Menu;
import com.hubdosabor.hubdosabor.restaurant.model.Restaurant;
import com.hubdosabor.hubdosabor.restaurant.repository.MenuRepository;
import com.hubdosabor.hubdosabor.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    public List<MenuResponse> getAll() {
        List<Menu> menu = menuRepository.findAll();
        return menu.stream()
                .map(menuMapper::toResponse)
                .toList();
    }

    public MenuResponse addMenu(Long id, MenuRequest request, String ownerEmail) {

        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found."));

        if (!restaurant.getOwner().getEmail().equals(ownerEmail)) {
            throw new AccessDeniedException("User not found");
        }

        Menu newMenu = new Menu();
        newMenu.setName(request.name());
        newMenu.setDescription(request.description());
        newMenu.setPrice(request.price());
        newMenu.setRestaurant(restaurant);

        Menu saveMenu = menuRepository.save(newMenu);
        return menuMapper.toResponse(newMenu);
    }
}
