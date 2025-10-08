package com.hubdosabor.hubdosabor.restaurant.dto.request;

import com.hubdosabor.hubdosabor.restaurant.model.Address;

public record RestaurantRequest(
        String name,
        String description,
        Address address
) {
}
