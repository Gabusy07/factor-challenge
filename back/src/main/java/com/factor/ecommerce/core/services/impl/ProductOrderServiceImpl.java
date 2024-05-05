package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.core.dto.CartDTO;
import com.factor.ecommerce.core.mapper.CartMapper;
import com.factor.ecommerce.core.controller.request.ProductOrderRequest;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.Product;
import com.factor.ecommerce.core.model.ProductOrder;
import com.factor.ecommerce.core.persistence.repository.CartRepository;
import com.factor.ecommerce.core.persistence.repository.ProductOrderRepository;
import com.factor.ecommerce.core.services.interfaces.CartService;
import com.factor.ecommerce.core.services.interfaces.ProductOrderService;
import com.factor.ecommerce.core.services.interfaces.ProductService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private static final Logger logger = LoggerFactory.getLogger(ProductOrderService.class);
    private final ProductOrderRepository productOrderRepository;
    private final CartService cartService;

    private final ProductService productService;
    private final CartMapper cartMapper;
    private final CartRepository cartRepository;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository,
                                   CartService cartService,
                                   ProductService productService, CartMapper cartMapper, CartRepository cartRepository) {
        this.productOrderRepository = productOrderRepository;
        this.cartService = cartService;
        this.productService = productService;
        this.cartMapper = cartMapper;
        this.cartRepository = cartRepository;
    }


    @Transactional
    @Override
    public Optional<ProductOrder> createOrder(ProductOrderRequest request) {
        Optional<Cart> c_op = cartRepository.findById(request.getCartId());
        Optional<Product> p_op = productService.getProduct(request.getProductId());
        if ( c_op.isPresent() && p_op.isPresent()){
            ProductOrder item = new ProductOrder.Builder().quantityOrder(
                            request.getQuantityOrder())
                    .cart(c_op.get())
                    .product(p_op.get())
                    .build();
            return Optional.of(productOrderRepository.save(item));
        }
        return Optional.empty();
    }

    @Override
    public Boolean deleteProductOrder(Integer id) {
        Optional<ProductOrder> p = productOrderRepository.findById(id);
        if(p.isPresent()){
            productOrderRepository.delete(p.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<ProductOrder> update(Integer id, ProductOrderRequest request) {
        Optional<ProductOrder> op = productOrderRepository.findById(id);
        if(op.isPresent()){
            ProductOrder existingProduct = op.get();
                existingProduct.setQuantityOrder(request.getQuantityOrder());

            return Optional.of(productOrderRepository.save(existingProduct));
        }
        return Optional.empty();

    }


    @Override
    public Optional<ProductOrder> getOrder(Integer id) {
        return productOrderRepository.findById(id);
    }

    @Override
    public List<ProductOrder> getAll(Integer cartId) {
        return productOrderRepository.findAll();
    }
}
