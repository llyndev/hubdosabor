package com.hubdosabor.hubdosabor.users.dto.response;

import com.hubdosabor.hubdosabor.address.model.Address;
import com.hubdosabor.hubdosabor.users.model.User;

public record UserResponse(
        Long id,
        String name,
        String email,
        String telephone,
        Address address,
        User.Role role
) {
}
