package com.factor.ecommerce.core.services.interfaces;

import com.factor.ecommerce.core.controller.request.ProductOrderRequest;
import com.factor.ecommerce.core.dto.ProductOrderDTO;
import com.factor.ecommerce.core.model.ProductOrder;

import java.util.List;
import java.util.Optional;


public interface ProductOrderService {

    Optional<ProductOrder> createOrder(ProductOrderRequest request);
    Boolean deleteProductOrder(Integer id);

    Optional<ProductOrder> update(Integer id, ProductOrderRequest request);
    ProductOrderDTO getOrder(Integer id);
    List<ProductOrderDTO> getAll(Integer cartId);
}
