package com.hubdosabor.hubdosabor.restaurant.dto.request;

import java.math.BigDecimal;

public record MenuRequest(
        String name,
        String description,
        BigDecimal price
) {
}
