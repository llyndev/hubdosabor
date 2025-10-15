package com.hubdosabor.hubdosabor.restaurant.dto.request;

public record RestaurantRequest(
        String name,
        String description,
        String cep,
        String number
) {
}
