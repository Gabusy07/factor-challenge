package com.factor.ecommerce.auth.service;

import com.factor.ecommerce.auth.dto.TokenResponse;
import com.factor.ecommerce.auth.model.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public interface UserService {
    TokenResponse login(User user) throws RuntimeException;
    User createUser(User user);

    User update(User user);

    Optional<User> getById(Integer id);
}
