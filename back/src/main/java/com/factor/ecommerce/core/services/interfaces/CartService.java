package com.factor.ecommerce.core.services.interfaces;

import com.factor.ecommerce.core.model.Cart;

import java.util.Optional;

public interface CartService {

    Cart create();
    Cart update(Integer id, Cart cart);
    void delete(Integer id);
    Optional<Cart> getCart(Integer id); //TODO modificar para obtener por id de usuario

}
