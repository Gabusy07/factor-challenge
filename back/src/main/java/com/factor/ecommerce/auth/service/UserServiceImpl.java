package com.factor.ecommerce.auth.service;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.persistence.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(User user) throws RuntimeException {
        Optional<User> userOptional = this.userRepository.findByUsername(user.getUsername());
        if (userOptional.isEmpty()) throw new EntityNotFoundException("bad credentials");
        else if ( !userOptional.get().getPassword().equals(user.getPassword())) throw new RuntimeException("the password is incorrect");
        return userOptional.get();
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }
}
