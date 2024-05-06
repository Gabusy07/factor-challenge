package com.factor.ecommerce.auth.service;

import com.factor.ecommerce.auth.controller.request.UserRequest;
import com.factor.ecommerce.auth.controller.request.response.UserResponse;
import com.factor.ecommerce.auth.model.User;

import java.util.Optional;

public interface UserService {
    UserResponse login(UserRequest user) throws RuntimeException;
    User createUser(User user);

    User update(User user);

    Optional<User> getById(Integer id);
}
