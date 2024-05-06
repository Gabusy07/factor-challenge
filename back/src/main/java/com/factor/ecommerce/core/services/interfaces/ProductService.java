package com.factor.ecommerce.core.services.interfaces;


import com.factor.ecommerce.core.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product create(Product product);
    Product update(Integer id, Product product);
    void delete(Integer id);
    Optional<Product> getProduct(Integer id);
    List<Product> getAll();
}
