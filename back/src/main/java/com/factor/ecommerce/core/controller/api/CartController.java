package com.factor.ecommerce.core.controller.api;

import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.services.interfaces.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cart/")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("{userId}")
    public ResponseEntity<Cart> obtainCart(@PathVariable Integer userId){
        Optional<Cart> op = cartService.getCart(userId);
        if (op.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(op.get());
    }
}
