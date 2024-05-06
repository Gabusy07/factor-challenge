package com.factor.ecommerce.auth.controller;

import com.factor.ecommerce.auth.dto.TokenResponse;
import com.factor.ecommerce.auth.exception.IncorrectPasswordException;
import com.factor.ecommerce.auth.exception.UsernameNotFoundException;
import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.service.JwtTokenService;
import com.factor.ecommerce.auth.service.UserService;
import com.factor.ecommerce.auth.utils.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;



    public AuthController(UserService userService ) {
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody User request){
           try{
               TokenResponse token = userService.login(request);
               return ResponseEntity.ok().body(token);

           }catch (IncorrectPasswordException e){
               logger.error(e.getMessage());
               e.printStackTrace();
               return  ResponseEntity.badRequest().body(e.getMessage());

           }
           catch (UsernameNotFoundException e){
               logger.error(e.getMessage());
               e.printStackTrace();
               return  ResponseEntity.badRequest().body(e.getMessage());
           }
           catch (Exception e){
               logger.error(e.getMessage());
               e.printStackTrace();
               return  ResponseEntity.internalServerError().build();
           }

    }
}
