package com.hubdosabor.hubdosabor.users.mapper;

import com.hubdosabor.hubdosabor.users.dto.response.UserResponse;
import com.hubdosabor.hubdosabor.users.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toDTO(User user) {
        if (user == null) return null;

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getTelephone(),
                user.getRole()
        );
    }

}
