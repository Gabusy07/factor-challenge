package com.factor.ecommerce.auth.service;

import com.factor.ecommerce.auth.model.User;
import jakarta.persistence.EntityNotFoundException;

public interface UserService {
    User getUser(User user) throws RuntimeException;
    User createUser(User user);
}
