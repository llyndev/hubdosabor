package com.hubdosabor.hubdosabor.restaurant.service;

import com.hubdosabor.hubdosabor.config.exception.custom.ResourceNotFoundException;
import com.hubdosabor.hubdosabor.restaurant.dto.request.RestaurantRequest;
import com.hubdosabor.hubdosabor.restaurant.dto.response.RestaurantResponse;
import com.hubdosabor.hubdosabor.restaurant.mapper.RestaurantMapper;
import com.hubdosabor.hubdosabor.restaurant.model.Restaurant;
import com.hubdosabor.hubdosabor.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantResponse create(RestaurantRequest request) {
        if (restaurantRepository.findByNameContainingIgnoreCase(request.name()).isPresent()) {
            throw new IllegalStateException("There is already a restaurant with that name");
        }

        Restaurant restaurante = restaurantMapper.toEntity(request);

        Restaurant restauranteSalvo = restaurantRepository.save(restaurante);

        return restaurantMapper.toResponse(restauranteSalvo);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public RestaurantResponse update(Long id, RestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Restaurant not found.")
        );

        if (request.name() != null) {
            if (restaurantRepository.findByNameContainingIgnoreCase(request.name()).isPresent()) {
                throw new IllegalStateException("There is already a restaurant with that name");
            }

            restaurant.setName(request.name());
        }

        if (request.description() != null) {
            restaurant.setDescription(request.description());
        }

        if (request.address() != null) {
            restaurant.setAddress(request.address());
        }

        Restaurant upRestaurante = restaurantRepository.save(restaurant);

        return restaurantMapper.toDTO(upRestaurante);

    }

}
