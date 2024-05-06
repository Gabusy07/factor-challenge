package com.factor.ecommerce.auth.controller;

import com.factor.ecommerce.auth.controller.request.UserRequest;
import com.factor.ecommerce.auth.controller.request.response.ErrorResponse;
import com.factor.ecommerce.auth.controller.request.response.UserResponse;
import com.factor.ecommerce.auth.exception.IncorrectPasswordException;
import com.factor.ecommerce.auth.exception.UsernameNotFoundException;
import com.factor.ecommerce.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> login(@RequestBody UserRequest request){
           try{
               UserResponse response = userService.login(request);
               return ResponseEntity.status(HttpStatus.OK).body(response);

           }catch (IncorrectPasswordException e){
               logger.error(e.getMessage());
               e.printStackTrace();
               return  ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));

           }
           catch (UsernameNotFoundException e){
               logger.error(e.getMessage());
               e.printStackTrace();
               return  ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
           }
           catch (Exception e){
               logger.error(e.getMessage());
               e.printStackTrace();
               return  ResponseEntity.internalServerError().build();
           }

    }
}
