package com.factor.ecommerce.auth.service;

import com.factor.ecommerce.auth.model.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public interface UserService {
    String login(User user) throws RuntimeException;
    User createUser(User user);

    Optional<User> getById(Integer id);
}
