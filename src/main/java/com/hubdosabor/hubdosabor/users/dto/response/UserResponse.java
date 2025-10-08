package com.hubdosabor.hubdosabor.users.dto.response;

import com.hubdosabor.hubdosabor.users.model.User;

public record UserResponse(
        Long id,
        String name,
        String email,
        String telephone,
        User.Role role
) {
}
