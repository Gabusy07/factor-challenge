package com.factor.ecommerce.services.interfaces;

import com.factor.ecommerce.controller.request.ProductItemRequest;
import com.factor.ecommerce.model.ProductItem;

import java.util.List;

public interface ProductItemService {

    void createItem(ProductItemRequest request);
    void deleteProductItem(Integer id);

    void update(Integer id, ProductItemRequest request);
    ProductItem getItem(Integer id);
    List<ProductItem> getAll(Integer cartId);
}
