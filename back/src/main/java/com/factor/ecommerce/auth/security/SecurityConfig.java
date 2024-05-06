package com.factor.ecommerce.auth.security;

import com.factor.ecommerce.auth.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    //@Value("${jwt.secret}")
    //private String jwtSecret = "fndfn d";

    //@Value("${jwt.expiration}")
    //private int jwtExpiration = 90000;

    @Bean
    public JwtUtil jwtTokenUtil() {
        return new JwtUtil();
    }
}

