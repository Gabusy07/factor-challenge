package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.service.UserService;
import com.factor.ecommerce.core.dto.CartDTO;
import com.factor.ecommerce.core.mapper.CartMapper;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.ProductOrder;
import com.factor.ecommerce.core.persistence.repository.CartRepository;
import com.factor.ecommerce.core.persistence.repository.ProductOrderRepository;
import com.factor.ecommerce.core.services.interfaces.CartService;
import com.factor.ecommerce.core.services.interfaces.DiscountService;
import com.factor.ecommerce.core.services.interfaces.ProductOrderService;
import jakarta.persistence.EntityNotFoundException;
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
    private final UserService userService;
    private final DiscountService discountService;
    private final CartMapper cartMapper;

    private final ProductOrderRepository productOrderRepository;


    public CartServiceImpl(CartRepository cartRepository,
                           UserService userService,
                           DiscountService discountService, CartMapper cartMapper
                           , ProductOrderRepository productOrderRepository) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.discountService = discountService;
        this.cartMapper = cartMapper;
        this.productOrderRepository = productOrderRepository;
    }


    @Transactional
    @Override
    public CartDTO update(CartDTO cartDto,Integer userId) {
        //TODO trabajar con ProductOrderRequest o custom DTO en lugar de la entidad ProductOrder
        Optional<User> userOptional = userService.getById(userId);
        if (userOptional.isEmpty()) {
            logger.error("User not found");
            return null;
        }
        Cart oldCart = cartRepository.findActiveByUserId(userId).orElseThrow(
                () -> new EntityNotFoundException("Cart " + cartDto.getId() + " not found")
        );

        if (isCartExpired(oldCart)) {
            oldCart.setActive(false);
            return cartMapper.cartToCartDTO(cartRepository.save(oldCart));
        }

        List<ProductOrder> productOrders = saveAllProductOrders(cartDto);

        User user = userOptional.get();
        Double totalPrice = calculateTotalPrice(oldCart, user);
        Cart cartUpdated = updateCartProducts(
                oldCart,
                totalPrice,
                productOrders);
        return cartMapper.cartToCartDTO(cartUpdated);
    }

    private List<ProductOrder> saveAllProductOrders(CartDTO cartDTO) {
        List<ProductOrder> productOrders = productOrderRepository.saveAll(cartDTO.getProductOrders());
        return productOrders;
    }


    private Cart updateCartProducts(Cart oldCart, Double totalPrice, List<ProductOrder> productOrder) {
        return new Cart.Builder()
                .id(oldCart.getId())
                .isActive(oldCart.getActive())
                .totalPrice(totalPrice)
                .user(oldCart.getUser())
                .maxDateAvailable(oldCart.getMaxDateAvailable())
                .productOrders(productOrder) // unico campo alterado
                .initialDate(oldCart.getInitialDate())
                .build();
    }


    private Cart updateCart(Cart oldCart, Double totalPrice) {
        return new Cart.Builder()
                .id(oldCart.getId())
                .isActive(oldCart.getActive())
                .totalPrice(totalPrice)
                .user(oldCart.getUser())
                .maxDateAvailable(oldCart.getMaxDateAvailable())
                .productOrders(oldCart.getProductOrders())
                .initialDate(oldCart.getInitialDate())
                .build();
    }


    @Transactional
    @Override
    public Optional<CartDTO> getCart(Integer userId) {
        Optional<User> userOptional = userService.getById(userId);
        if (userOptional.isEmpty()) {
            logger.error("User not found");
            return Optional.empty();
        }

        User user = userOptional.get();
        Optional<Cart> activeCartOptional = user.getCarts().stream()
                .filter(Cart::getActive)
                .findFirst();

        if (activeCartOptional.isEmpty()) {
            return Optional.ofNullable(cartMapper.cartToCartDTO(create(user)));
        }
        Cart oldCart = activeCartOptional.get();

        if (isCartExpired(oldCart)) {
            oldCart.setActive(false);
            cartRepository.save(oldCart);
            return Optional.ofNullable(cartMapper.cartToCartDTO(create(user)));
        }

        Double totalPrice = calculateTotalPrice(oldCart, user);

        Cart updatedCart = updateCart(oldCart, totalPrice);
        CartDTO cartDTO = cartMapper.cartToCartDTO(updatedCart);

        return Optional.of(cartDTO);
    }

    private boolean isCartExpired(Cart cart) {
        return cart.getMaxDateAvailable().isBefore(LocalDateTime.now());
    }

    private Double calculateTotalPrice(Cart cart, User user) {
        return discountService.applyDiscount(cart, user);
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
        user.getCarts().add(cart);
        //userService.update(user);
        return cartRepository.save(cart);
    }

}

