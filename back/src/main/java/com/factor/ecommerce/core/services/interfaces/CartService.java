package com.factor.ecommerce.core.services.interfaces;


import com.factor.ecommerce.core.dto.CartDTO;


import java.util.List;
import java.util.Optional;

public interface CartService {
    CartDTO update(CartDTO cartDto, Integer userId);
    Optional<CartDTO> getCart(Integer userId);

    Boolean executePurchase(Integer id);


}
