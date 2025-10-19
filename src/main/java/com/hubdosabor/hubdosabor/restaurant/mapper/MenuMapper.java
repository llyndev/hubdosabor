package com.hubdosabor.hubdosabor.restaurant.mapper;

import com.hubdosabor.hubdosabor.restaurant.dto.response.MenuResponse;
import com.hubdosabor.hubdosabor.restaurant.model.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuMapper {

    public MenuResponse toResponse(Menu menu) {
        if (menu == null) {
            return null;
        }

        return new MenuResponse(
                menu.getId(),
                menu.getName(),
                menu.getDescription(),
                menu.getPrice()
        );
    }
}
