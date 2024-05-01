package com.factor.ecommerce.services.impl;

import com.factor.ecommerce.controller.request.ProductItemRequest;
import com.factor.ecommerce.model.Cart;
import com.factor.ecommerce.model.Product;
import com.factor.ecommerce.model.ProductItem;
import com.factor.ecommerce.persistence.repository.ProductItemRepository;
import com.factor.ecommerce.services.interfaces.CartService;
import com.factor.ecommerce.services.interfaces.ProductItemService;
import com.factor.ecommerce.services.interfaces.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductItemServiceImpl implements ProductItemService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductItemRepository productItemRepository;
    private final CartService cartService;

    private final ProductService productService;

    public ProductItemServiceImpl(ProductItemRepository productItemRepository, CartService cartService, ProductService productService) {
        this.productItemRepository = productItemRepository;
        this.cartService = cartService;
        this.productService = productService;
    }


    @Override
    public void createItem(ProductItemRequest request) {
        Cart cart = cartService.getCart(request.getCartId());
        Product product = productService.getProduct(request.getProductId());
        ProductItem item = new ProductItem.Builder().quantityOrder(
                request.getQuantityOrder())
                .cart(cart)
                .product(product)
                .build();
        productItemRepository.save(item);

    }

    @Override
    public void deleteProductItem(Integer id) {
        Optional<ProductItem> p = productItemRepository.findById(id);
        if(p.isPresent()){
            productItemRepository.delete(p.get());
        }
    }

    @Override
    public void update(Integer id,ProductItemRequest request) {
        Optional<ProductItem> op = productItemRepository.findById(id);
        if(op.isPresent()){
            ProductItem existingProduct = op.get();
            existingProduct.setQuantityOrder(request.getQuantityOrder());
            productItemRepository.save(existingProduct);
        }


    }


    @Override
    public ProductItem getItem(Integer id) {
        return productItemRepository.findById(id).get();
    }

    @Override
    public List<ProductItem> getAll(Integer cartId) {
        return productItemRepository.findAll();
    }
}
