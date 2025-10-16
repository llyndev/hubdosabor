package com.hubdosabor.hubdosabor.restaurant.dto.response;

import com.hubdosabor.hubdosabor.restaurant.model.Restaurant;

import java.math.BigDecimal;

public record MenuResponse(
        Long id,
        String name,
        String description,
        BigDecimal price
) {
}
