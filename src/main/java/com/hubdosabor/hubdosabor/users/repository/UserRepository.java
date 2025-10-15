package com.hubdosabor.hubdosabor.users.repository;

import com.hubdosabor.hubdosabor.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailContainingIgnoreCase(String email);
}
