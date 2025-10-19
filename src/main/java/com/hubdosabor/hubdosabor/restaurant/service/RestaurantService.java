package com.hubdosabor.hubdosabor.restaurant.service;

import com.hubdosabor.hubdosabor.address.dto.response.CepResponse;
import com.hubdosabor.hubdosabor.address.mapper.AddressMapper;
import com.hubdosabor.hubdosabor.address.model.Address;
import com.hubdosabor.hubdosabor.address.service.CepService;
import com.hubdosabor.hubdosabor.config.exception.custom.ResourceNotFoundException;
import com.hubdosabor.hubdosabor.restaurant.dto.request.RestaurantRequest;
import com.hubdosabor.hubdosabor.restaurant.dto.response.RestaurantResponse;
import com.hubdosabor.hubdosabor.restaurant.mapper.MenuMapper;
import com.hubdosabor.hubdosabor.restaurant.mapper.RestaurantMapper;
import com.hubdosabor.hubdosabor.restaurant.model.Restaurant;
import com.hubdosabor.hubdosabor.restaurant.repository.MenuRepository;
import com.hubdosabor.hubdosabor.restaurant.repository.RestaurantRepository;
import com.hubdosabor.hubdosabor.users.model.User;
import com.hubdosabor.hubdosabor.users.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final AddressMapper addressMapper;
    private final CepService cepService;
    private final UserRepository userRepository;

    public RestaurantResponse create(RestaurantRequest request, String ownerEmail) {
        User owner = userRepository.findByEmailContainingIgnoreCase(ownerEmail)
                .orElseThrow(() -> new RuntimeException("Owner not found with email: " + ownerEmail));

        if (restaurantRepository.findByNameContainingIgnoreCase(request.name()).isPresent()) {
            throw new IllegalStateException("There is already a restaurant with that name");
        }

        CepResponse cepResponse = cepService.getCep(request.cep());
        Address address = addressMapper.toEntity(cepResponse, request.number());

        Restaurant restaurant = restaurantMapper.toEntity(request);

        restaurant.setAddress(address);
        restaurant.setOwner(owner);

        Restaurant restauranteSalvo = restaurantRepository.save(restaurant);

        return restaurantMapper.toResponse(restauranteSalvo);
    }

    public List<RestaurantResponse> getAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(restaurantMapper::toResponse)
                .toList();
    }

    public RestaurantResponse update(Long id, RestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Restaurant not found.")
        );

        CepResponse cepResponse = cepService.getCep(request.cep());
        Address address = addressMapper.toEntity(cepResponse, request.number());

        if (request.name() != null) {
            if (restaurantRepository.findByNameContainingIgnoreCase(request.name()).isPresent()) {
                throw new IllegalStateException("There is already a restaurant with that name");
            }

            restaurant.setName(request.name());
        }

        if (request.description() != null) {
            restaurant.setDescription(request.description());
        }

        if (request.cep() != null) {
            restaurant.setAddress(address);
        }

        Restaurant upRestaurante = restaurantRepository.save(restaurant);

        return restaurantMapper.toResponse(upRestaurante);

    }

    public RestaurantResponse findById(Long id) {
        Restaurant restaurant = restaurantRepository.findByIdWithMenu(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));

        return restaurantMapper.toResponse(restaurant);
    }

}
