package com.hubdosabor.hubdosabor.restaurant.mapper;

import com.hubdosabor.hubdosabor.address.dto.response.CepResponse;
import com.hubdosabor.hubdosabor.address.model.Address;
import com.hubdosabor.hubdosabor.address.service.CepService;
import com.hubdosabor.hubdosabor.restaurant.dto.request.RestaurantRequest;
import com.hubdosabor.hubdosabor.restaurant.dto.response.RestaurantResponse;
import com.hubdosabor.hubdosabor.restaurant.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

    private final CepService cepService;

    public RestaurantMapper(CepService cepService) {
        this.cepService = cepService;
    }

    public RestaurantResponse toResponse(Restaurant restaurant) {
        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getAddress()
        );
    }

    public Restaurant toEntity(RestaurantRequest request) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.name());
        restaurant.setDescription(request.description());
        return restaurant;
    }

    public RestaurantResponse toDTO(Restaurant restaurant) {
        if (restaurant == null) return null;

        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getAddress()
        );
    }
}
