package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.utils.UserType;
import com.factor.ecommerce.core.controller.request.ProductOrderRequest;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.persistence.repository.CartRepository;
import com.factor.ecommerce.core.services.interfaces.CartService;
import com.factor.ecommerce.core.services.interfaces.ProductOrderService;
import com.factor.ecommerce.core.services.interfaces.SpecialDateService;
import com.factor.ecommerce.core.utils.CartType;
import com.factor.ecommerce.exception.CartNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private final CartRepository cartRepository;
    private final SpecialDateService specialDateService;

    private final ProductOrderService productOrderService;

    public CartServiceImpl(CartRepository cartRepository, SpecialDateService specialDateService, ProductOrderService productOrderService) {
        this.cartRepository = cartRepository;
        this.specialDateService = specialDateService;
        this.productOrderService = productOrderService;
    }


    @Override
    public Cart update(Integer id, Cart cart) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
    @Transactional
    @Override
    public Optional<Cart> getCart(Integer userId) {

        //Optional User op = userRepository.findById(userId);
        Optional<User> userOptional = Optional.of(new User());
        //if (userOptional.isPresent()) {
        if (true) {
            logger.atWarn().log("ENTRA EN TRUE CREATE");
            User user = userOptional.get();
            Optional<Cart> cartOptional = cartRepository.findById(1); // user.id
            if (cartOptional.isPresent()) {
                Cart oldCart = cartOptional.get();
                Double totalPrice = applyDiscount(oldCart);
                Cart cart = new Cart.Builder()
                        .setId(oldCart.getId())
                        .setIsActive(oldCart.getActive())
                        .setTotalPrice(totalPrice)
                        .setCartType(oldCart.getCartType())
                        .build();
                return Optional.of(cart);
            }
            CartType cartType = getCartType(user.getUserType());
            return create(cartType);
        }
        logger.error("User not found");
        return Optional.empty();
    }

    private Optional<Cart> create(CartType cartType) {
        LocalDateTime date = LocalDateTime.now();
        Cart cart = new Cart.Builder()
                .setCartType(cartType)
                .setIsActive(true)
                .setTotalPrice(0.0)
                .setInitialDate(date)
                .setmaxDateAvailable(date.plusHours(24))
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

    private Double applyDiscount(Cart cart) {
        Double totalAmount = cart.getTotalPrice();
        int productCount = cart.getProducts().size();

        if (productCount == 4) {
            totalAmount *= 0.75;
        } else if (productCount >= 10) {
            switch (cart.getCartType()) {
                case CART_VIP:
                    totalAmount -= 500.0;
                    break;
                case CART_DATE_SPECIAL:
                    totalAmount -= 300.0;
                    break;
                case CART_COMMON:
                    totalAmount -= 100.0;
                    break;
            }
            totalAmount = Math.max(totalAmount, 0.0);
        }
        return totalAmount;
    }
}
