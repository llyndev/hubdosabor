package com.hubdosabor.hubdosabor.restaurant.dto.response;

import com.hubdosabor.hubdosabor.address.model.Address;
import com.hubdosabor.hubdosabor.users.dto.response.UserResponse;

import java.util.List;

public record RestaurantResponse(
        Long id,
        String name,
        String description,
        Address address,
        List<MenuResponse> menuResponse,
        UserResponse owner
) {
}
