package com.factor.ecommerce.auth.service;

import com.factor.ecommerce.auth.dto.TokenResponse;
import com.factor.ecommerce.auth.exception.IncorrectPasswordException;
import com.factor.ecommerce.auth.exception.UsernameNotFoundException;
import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.persistence.UserRepository;
import com.factor.ecommerce.auth.utils.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;


    public UserServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public TokenResponse login(User user) throws RuntimeException {
        Optional<User> userOptional = this.userRepository.findByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            User dbUser = userOptional.get();
            String dbPassword = dbUser.getPassword();
            String inputPassword = user.getPassword();

            if (new BCryptPasswordEncoder().matches(inputPassword, dbPassword)) {
                String tokenStr = jwtUtil.generateToken(user.getUsername());
                TokenResponse token = new TokenResponse(tokenStr, null, user.getId());
                return token;
            } else {
                throw new IncorrectPasswordException("password incorrect");
            }
        } else {
            throw new UsernameNotFoundException("username incorrect");
        }
    }

    @Override
    public User createUser(User user) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        User newUser = new User.Builder()
                .username(user.getUsername())
                .password(encryptedPassword)
                .userType(user.getUserType())
                .build();
        return this.userRepository.save(newUser);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }
}
