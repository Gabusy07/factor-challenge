package com.factor.ecommerce.auth.controller;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.service.UserService;
import com.factor.ecommerce.core.controller.api.ProductController;
import com.factor.ecommerce.core.model.ProductOrder;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/login")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<?> getOne(@RequestBody User request){

        try {
            User user= userService.getUser(request);
            return ResponseEntity.ok().body(user);
        } catch ( EntityNotFoundException e){
            logger.error(e.getMessage());
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
        catch ( RuntimeException e){
            logger.error(e.getMessage());
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
        catch ( Exception e){
            logger.error(e.getMessage());
            return  ResponseEntity.internalServerError().build();
        }
    }
}
