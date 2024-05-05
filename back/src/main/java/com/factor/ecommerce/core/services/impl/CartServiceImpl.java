package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.service.UserService;
import com.factor.ecommerce.core.dto.CartDTO;
import com.factor.ecommerce.core.mapper.CartMapper;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.persistence.repository.CartRepository;
import com.factor.ecommerce.core.services.interfaces.CartService;
import com.factor.ecommerce.core.services.interfaces.DiscountService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private final CartRepository cartRepository;
    private final UserService userService;
    private final DiscountService discountService;
    private final CartMapper cartMapper;


    public CartServiceImpl(CartRepository cartRepository,
                           UserService userService,
                           DiscountService discountService, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.discountService = discountService;
        this.cartMapper = cartMapper;
    }


    @Override
    public CartDTO update(CartDTO cartDto) {
        Cart existingCart = cartRepository.findById(cartDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("Cart " + cartDto.getId() + " not found")
        );
        return cartMapper.cartToCartDTO(existingCart);
    }

    @Override
    public void delete(Integer id) {

    }

    @Transactional
    @Override
    public Optional<CartDTO> getCart(Integer userId) {

        Optional<User> userOptional = userService.getById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Cart oldCart = user.getCart();
            if (oldCart != null) {
                Double totalPrice = this.discountService.applyDiscount(oldCart, user); // aplico descuento segun el tipo y dia
                Cart cart = new Cart.Builder()
                        .id(oldCart.getId())
                        .isActive(oldCart.getActive())
                        .totalPrice(totalPrice)
                        .user(oldCart.getUser())
                        .maxDateAvailable(oldCart.getMaxDateAvailable())
                        .productOrders(oldCart.getProductOrders())
                        .initialDate(oldCart.getInitialDate())
                        .build();
                CartDTO cartDTO = cartMapper.cartToCartDTO(cart);
                return Optional.of(cartDTO);
            }
            return Optional.ofNullable(cartMapper.cartToCartDTO(create(user)));
        }
        logger.error("User not found");
        return Optional.empty();
    }

    @Override
    public Boolean executePurchase(Integer id) {
        Cart existingCart = cartRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Cart " + id + " not found")
        );
        existingCart.setActive(false);
        cartRepository.save(existingCart);
        return true;
    }

    @Transactional
    private Cart create(User user) {
        LocalDateTime date = LocalDateTime.now();
        Cart cart = new Cart.Builder()
                .isActive(true)
                .totalPrice(0.0)
                .initialDate(date)
                .maxDateAvailable(date.plusHours(24))
                .user(user)
                .build();
        user.setCart(cart);
        userService.update(user);
        return cartRepository.save(cart);
    }

    /*
    private CartType getCartType(UserType userType) {
        CartType ct = CartType.CART_COMMON;
        if (userType.equals(UserType.USER_VIP)) {
            ct = CartType.CART_VIP;
        } else if (this.isSpecialDate()) {
            ct = CartType.CART_DATE_SPECIAL;
        }
        return ct;
    }*/

}

