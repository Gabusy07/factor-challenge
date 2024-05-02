package com.factor.ecommerce.services.impl;

import com.factor.ecommerce.controller.request.ProductOrderRequest;
import com.factor.ecommerce.model.Cart;
import com.factor.ecommerce.model.Product;
import com.factor.ecommerce.model.ProductOrder;
import com.factor.ecommerce.persistence.repository.ProductOrderRepository;
import com.factor.ecommerce.services.interfaces.CartService;
import com.factor.ecommerce.services.interfaces.ProductOrderService;
import com.factor.ecommerce.services.interfaces.ProductService;
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

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository,
                                   CartService cartService,
                                   ProductService productService) {
        this.productOrderRepository = productOrderRepository;
        this.cartService = cartService;
        this.productService = productService;
    }


    @Override
    public void createOrder(ProductOrderRequest request) {
        Cart cart = cartService.getCart(request.getCartId());
        Product product = productService.getProduct(request.getProductId());
        ProductOrder item = new ProductOrder.Builder().quantityOrder(
                request.getQuantityOrder())
                .cart(cart)
                .product(product)
                .build();
        productOrderRepository.save(item);

    }

    @Override
    public void deleteProductOrder(Integer id) {
        Optional<ProductOrder> p = productOrderRepository.findById(id);
        if(p.isPresent()){
            productOrderRepository.delete(p.get());
        }
    }

    @Override
    public void update(Integer id, ProductOrderRequest request) {
        Optional<ProductOrder> op = productOrderRepository.findById(id);
        if(op.isPresent()){
            ProductOrder existingProduct = op.get();
            existingProduct.setQuantityOrder(request.getQuantityOrder());
            productOrderRepository.save(existingProduct);
        }


    }


    @Override
    public ProductOrder getOrder(Integer id) {
        return productOrderRepository.findById(id).get();
    }

    @Override
    public List<ProductOrder> getAll(Integer cartId) {
        return productOrderRepository.findAll();
    }
}
