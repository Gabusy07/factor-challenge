package com.factor.ecommerce.services.impl;

import com.factor.ecommerce.model.Product;
import com.factor.ecommerce.services.interfaces.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product update(Integer id, Product product) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
