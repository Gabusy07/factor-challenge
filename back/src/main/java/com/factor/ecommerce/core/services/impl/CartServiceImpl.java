package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.utils.UserType;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.persistence.repository.CartRepository;
import com.factor.ecommerce.core.services.interfaces.CartService;
import com.factor.ecommerce.core.services.interfaces.SpecialDateService;
import com.factor.ecommerce.core.utils.CartType;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final SpecialDateService specialDateService;

    public CartServiceImpl(CartRepository cartRepository, SpecialDateService specialDateService) {
        this.cartRepository = cartRepository;
        this.specialDateService = specialDateService;
    }


    @Override
    public Cart update(Integer id, Cart cart) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
    @Override
    public Optional<Cart> getCart(Integer userId) {

        //Optional User op = userRepository.findById(userId);

        Optional<User> op = Optional.of(new User());
        Integer cartId = op.get().getId();
        if(cartRepository.existsById(cartId)){
            return cartRepository.findById(cartId);
        }
        CartType cartType = this.getCartType(op.get().getUserType());
        return this.create(cartType);
    }

    private Optional<Cart> create(CartType cartType) {
        Cart cart = new Cart.Builder()
                .setCartType(cartType)
                .setIsActive(true)
                .setTotalPrice(0.0)
                .build();
        return Optional.of(cartRepository.save(cart));
    }

    private CartType getCartType(UserType userType) {
        CartType ct = CartType.CART_COMMON;
        if (userType.equals(UserType.USER_VIP)){
            ct = CartType.CART_VIP;
        }
        else if (this.isSpecialDate()){
            ct = CartType.CART_DATE_SPECIAL;
        }
        return ct;
    }

    private Boolean isSpecialDate() {
        return specialDateService.isASpecialDate();
    }
}
