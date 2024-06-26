package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.auth.service.UserService;
import com.factor.ecommerce.core.dto.CartDTO;
import com.factor.ecommerce.core.mapper.CartMapper;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.Product;
import com.factor.ecommerce.core.model.ProductOrder;
import com.factor.ecommerce.core.persistence.repository.CartRepository;
import com.factor.ecommerce.core.persistence.repository.ProductRepository;
import com.factor.ecommerce.core.services.interfaces.CartService;
import com.factor.ecommerce.core.services.interfaces.DiscountService;
import com.factor.ecommerce.core.services.interfaces.ProductOrderService;
import com.factor.ecommerce.exception.ProductException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService {

    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

    private final CartRepository cartRepository;

    private final ProductRepository productRepository;
    private final UserService userService;
    private final DiscountService discountService;
    private final CartMapper cartMapper;

    private final ProductOrderService productOrderService;


    public CartServiceImpl(CartRepository cartRepository,
                           ProductRepository productRepository, UserService userService,
                           DiscountService discountService,
                           CartMapper cartMapper,
                           ProductOrderService productOrderService) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userService = userService;
        this.discountService = discountService;
        this.cartMapper = cartMapper;
        this.productOrderService = productOrderService;
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
        List<ProductOrder> productOrders = saveAllProductOrders(cartDto);
        Cart oldCart = cartRepository.findActiveByUserId(userId).orElseThrow(
                () -> new EntityNotFoundException("Cart " + cartDto.getId() + " not found")
        );

        if (isCartExpired(oldCart)) {
            oldCart.setActive(false);
            logger.info("Cart was expirated");
            return cartMapper.cartToCartDTO(cartRepository.save(oldCart));
        }

        User user = userOptional.get();
        Cart cartUpdated = updateCartProducts(
                oldCart,
                productOrders);

        Map<String, Double> totalAmountAndDiscount = getTotalAmountCalculatedAndDiscount(cartUpdated, user);
        
        cartUpdated.setTotalPrice(totalAmountAndDiscount.get("totalAmountAfterDiscount"));
        CartDTO cartSaved = cartMapper.cartToCartDTO(cartRepository.save(cartUpdated));
        cartSaved.setTotalDiscount(totalAmountAndDiscount.get("discountAmount"));
        return cartSaved;
    }

    private List<ProductOrder> saveAllProductOrders(CartDTO cartDTO) {
        List<ProductOrder> productOrders =  new ArrayList<>();
        for (ProductOrder order : cartDTO.getProductOrders()){
            ProductOrder p = productOrderService.update(order.getId(), order);
            if (p.getQuantityOrder() > 0) productOrders.add(p);
        }
        return productOrders;
    }


    private Cart updateCartProducts(Cart oldCart, List<ProductOrder> productOrder) {
        return new Cart.Builder()
                .id(oldCart.getId())
                .isActive(oldCart.getActive())
                .user(oldCart.getUser())
                .totalPrice(oldCart.getTotalPrice())
                .maxDateAvailable(oldCart.getMaxDateAvailable())
                .productOrders(productOrder) // unico campo alterado
                .initialDate(oldCart.getInitialDate())
                .build();
    }


    private Cart updateCart(Cart oldCart) {
        return new Cart.Builder()
                .id(oldCart.getId())
                .isActive(oldCart.getActive())
                //.totalPrice(totalPrice)
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

        Map<String, Double> totalAmountAndDiscount = getTotalAmountCalculatedAndDiscount(oldCart, user);

        Cart updatedCart = updateCart(oldCart);
        CartDTO cartDTO = cartMapper.cartToCartDTO(updatedCart);
        cartDTO.setTotalDiscount(totalAmountAndDiscount.get("discountAmount"));
        cartDTO.setTotalPrice(totalAmountAndDiscount.get("totalAmountAfterDiscount"));

        return Optional.of(cartDTO);
    }

    private boolean isCartExpired(Cart cart) {
        return cart.getMaxDateAvailable().isBefore(LocalDateTime.now());
    }

    private Map<String, Double> getTotalAmountCalculatedAndDiscount(Cart cart, User user) {
        return discountService.applyDiscount(cart, user);
    }

    @Transactional
    @Override
    public void executePurchase(CartDTO cartDTO) {
        Cart existingCart = cartRepository.findById(cartDTO.getId()).orElseThrow(
                () -> new EntityNotFoundException("Cart " + cartDTO.getId() + " not found")
        );
        List<ProductOrder> orders = existingCart.getProductOrders();
        for (ProductOrder po : orders){
            Product p = po.getProduct();
            p.decreaseStock(po.getQuantityOrder());
            if (p.getStock() < 0) throw new ProductException("Non valid stock result");
            productRepository.save(p);
        }
        existingCart.setActive(false);
        cartRepository.save(existingCart);
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

