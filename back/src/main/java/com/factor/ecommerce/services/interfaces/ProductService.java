package com.factor.ecommerce.services.interfaces;


import com.factor.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product create(Product product);
    Product update(Integer id, Product product);
    void delete(Integer id);
    Product getProduct(Integer id);
    List<Product> getAll();
}
