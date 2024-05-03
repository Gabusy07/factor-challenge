package com.factor.ecommerce.core.services.interfaces;

import com.factor.ecommerce.core.controller.request.ProductOrderRequest;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.ProductOrder;
import com.factor.ecommerce.exception.CartNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart update(Integer id, Cart cart);
    void delete(Integer id);
    Optional<Cart> getCart(Integer userId); //TODO modificar para obtener por id de usuario

}
