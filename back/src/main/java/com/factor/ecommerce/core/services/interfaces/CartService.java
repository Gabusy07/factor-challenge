package com.factor.ecommerce.core.services.interfaces;

import com.factor.ecommerce.core.controller.request.ProductOrderRequest;
import com.factor.ecommerce.core.dto.CartDTO;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.ProductOrder;
import com.factor.ecommerce.exception.CartNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CartService {
    CartDTO update(CartDTO cartDto);
    void delete(Integer id);
    Optional<CartDTO> getCart(Integer userId);

    Boolean executePurchase(Integer id);


}
