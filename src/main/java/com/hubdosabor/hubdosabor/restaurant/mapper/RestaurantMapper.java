package com.hubdosabor.hubdosabor.restaurant.mapper;

import com.hubdosabor.hubdosabor.restaurant.dto.request.RestaurantRequest;
import com.hubdosabor.hubdosabor.restaurant.dto.response.RestaurantResponse;
import com.hubdosabor.hubdosabor.restaurant.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

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
        restaurant.setAddress(request.address());
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
