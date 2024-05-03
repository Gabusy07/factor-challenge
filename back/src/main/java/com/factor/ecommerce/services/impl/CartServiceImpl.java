package com.factor.ecommerce.services.impl;

import com.factor.ecommerce.model.Cart;
import com.factor.ecommerce.persistence.repository.CartRepository;
import com.factor.ecommerce.services.interfaces.CartService;
import com.factor.ecommerce.utils.CartType;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    public Cart create() {
        Cart cart = new Cart.Builder()
                .setCartType(CartType.TYPE_COMMON)
                .setIsActive(true)
                .setTotalPrice(0.0)
                .build();
        return cartRepository.save(cart);
    }

    @Override
    public Cart update(Integer id, Cart cart) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Cart> getCart(Integer id) {
        return cartRepository.findById(id);
    }
}
