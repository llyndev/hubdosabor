package com.hubdosabor.hubdosabor.restaurant.mapper;

import com.hubdosabor.hubdosabor.restaurant.dto.request.RestaurantRequest;
import com.hubdosabor.hubdosabor.restaurant.dto.response.MenuResponse;
import com.hubdosabor.hubdosabor.restaurant.dto.response.RestaurantResponse;
import com.hubdosabor.hubdosabor.restaurant.model.Menu;
import com.hubdosabor.hubdosabor.restaurant.model.Restaurant;
import com.hubdosabor.hubdosabor.users.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {

    private final UserMapper userMapper;
    private final MenuMapper menuMapper;

    public RestaurantMapper(UserMapper userMapper, MenuMapper menuMapper) {
        this.userMapper = userMapper;
        this.menuMapper = menuMapper;
    }

    public RestaurantResponse toResponse(Restaurant restaurant) {

        if (restaurant == null) {
            return null;
        }

        List<Menu> menuList = restaurant.getMenus();

        List<MenuResponse> menuResponsesList = menuList.stream()
                    .map(menuMapper::toResponse)
                    .toList();

        return new RestaurantResponse(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getAddress(),
                menuResponsesList,
                userMapper.toResponse(restaurant.getOwner())
        );
    }

    public Restaurant toEntity(RestaurantRequest request) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.name());
        restaurant.setDescription(request.description());
        return restaurant;
    }
}
