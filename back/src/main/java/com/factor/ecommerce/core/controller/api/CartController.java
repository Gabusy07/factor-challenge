package com.factor.ecommerce.core.controller.api;

import com.factor.ecommerce.core.dto.CartDTO;
import com.factor.ecommerce.core.services.interfaces.CartService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carts/")
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> obtainCart(@PathVariable Integer userId) {
        Optional<CartDTO> op = cartService.getCart(userId);
        if (op.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(op.get());
      }

    @PatchMapping("update/{userId}")
    public ResponseEntity<?> updateCart(@PathVariable Integer userId,
                                        @RequestBody CartDTO cartDTO) {

        try {
            CartDTO response = cartService.update(cartDTO, userId);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        }catch (EntityNotFoundException e){
            logger.error(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("executePurchase/cartId:{id}")
    public ResponseEntity<?> executePurchase(@PathVariable Integer id) {
        Boolean hasBeenExecuted = cartService.executePurchase(id);
        if(hasBeenExecuted){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();

    }

}

