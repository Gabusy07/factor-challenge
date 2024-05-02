package com.factor.ecommerce.services.interfaces;

import com.factor.ecommerce.controller.request.ProductOrderRequest;
import com.factor.ecommerce.model.ProductOrder;

import java.util.List;


public interface ProductOrderService {

    void createOrder(ProductOrderRequest request);
    void deleteProductOrder(Integer id);

    void update(Integer id, ProductOrderRequest request);
    ProductOrder getOrder(Integer id);
    List<ProductOrder> getAll(Integer cartId);
}
