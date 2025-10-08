package com.hubdosabor.hubdosabor.restaurant.dto.response;

import com.hubdosabor.hubdosabor.restaurant.model.Address;

public record RestaurantResponse(
        Long id,
        String name,
        String description,
        Address address
) {
}
