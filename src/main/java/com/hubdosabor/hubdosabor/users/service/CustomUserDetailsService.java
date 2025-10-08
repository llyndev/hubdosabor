package com.hubdosabor.hubdosabor.users.service;

import com.hubdosabor.hubdosabor.users.model.User;
import com.hubdosabor.hubdosabor.users.repository.UserRepository;
import com.hubdosabor.hubdosabor.config.security.UserDeatilsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmailContainingIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with e-mail: " + email));
        return new UserDeatilsImpl(user);
    }
}
