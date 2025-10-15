package com.hubdosabor.hubdosabor.users.service;

import com.hubdosabor.hubdosabor.config.exception.custom.UnauthorizedException;
import com.hubdosabor.hubdosabor.config.security.UserDeatilsImpl;
import com.hubdosabor.hubdosabor.users.dto.response.UserResponse;
import com.hubdosabor.hubdosabor.users.mapper.UserMapper;
import com.hubdosabor.hubdosabor.users.model.User;
import com.hubdosabor.hubdosabor.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public UserResponse getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public UserResponse getMe(UserDeatilsImpl userDeatils) {
        if (userDeatils == null) {
            throw new UnauthorizedException("Unauthorized User");
        }

        User user = userDeatils.user();

        return userMapper.toDTO(user);
    }
}
