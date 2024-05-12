package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.core.dto.ProductOrderDTO;
import com.factor.ecommerce.core.mapper.CartMapper;
import com.factor.ecommerce.core.controller.request.ProductOrderRequest;
import com.factor.ecommerce.core.mapper.ProductOrderMapper;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.Product;
import com.factor.ecommerce.core.model.ProductOrder;
import com.factor.ecommerce.core.persistence.repository.CartRepository;
import com.factor.ecommerce.core.persistence.repository.ProductOrderRepository;
import com.factor.ecommerce.core.services.interfaces.CartService;
import com.factor.ecommerce.core.services.interfaces.ProductOrderService;
import com.factor.ecommerce.core.services.interfaces.ProductService;
import jakarta.persistence.EntityNotFoundException;
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


    private final ProductService productService;
    private final CartMapper cartMapper;
    private final CartRepository cartRepository;

    private final ProductOrderMapper productOrderMapper;

    public ProductOrderServiceImpl(
            ProductOrderRepository productOrderRepository,
                                   ProductService productService, CartMapper cartMapper, CartRepository cartRepository, ProductOrderMapper productOrderMapper) {
        this.productOrderRepository = productOrderRepository;
        this.productService = productService;
        this.cartMapper = cartMapper;
        this.cartRepository = cartRepository;
        this.productOrderMapper = productOrderMapper;
    }


    @Transactional
    @Override
    public ProductOrder createOrder(ProductOrderRequest request) {
        Cart cart = cartRepository.findById(request.getCartId()).orElse(null);
        Product product = productService.getProduct(request.getProductId()).orElse(null);

        ProductOrder item;
        Optional<ProductOrder> orderOp = productOrderRepository.findByCartAndProduct(cart, product);

        if (orderOp.isPresent()) {
            ProductOrder oldOrder = orderOp.get();
            item = new ProductOrder.Builder()
                    .quantityOrder(oldOrder.getQuantityOrder() + request.getQuantityOrder())
                    .cart(oldOrder.getCart())
                    .product(oldOrder.getProduct())
                    .build();
        } else {
            item = new ProductOrder.Builder()
                    .quantityOrder(request.getQuantityOrder())
                    .cart(cart)
                    .product(product)
                    .build();
        }

        ProductOrder po = productOrderRepository.save(item);

        if (cart != null) {
            cart.getOrders().add(po);
            cartRepository.save(cart);
        }
        return po;
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
    public ProductOrder update(Integer id, ProductOrder order) {
        Optional<ProductOrder> op = productOrderRepository.findById(id);
        if(op.isPresent()){
            ProductOrder existingProduct = op.get();
                existingProduct.setQuantityOrder(order.getQuantityOrder());

            return productOrderRepository.save(existingProduct);
        }
        return null;

    }


    @Override
    public ProductOrderDTO getOrder(Integer id) {
        ProductOrder productOrder = productOrderRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("order not found")
        );
        return productOrderMapper.productOrderToProductOrderDTO(productOrder);
    }

    @Override
    public List<ProductOrderDTO> getAll(Integer cartId) {

        return  productOrderMapper.productOrdersToProductOrdersDTO(productOrderRepository.findAll());
    }
}
