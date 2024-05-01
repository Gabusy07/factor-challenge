package com.factor.ecommerce.services.impl;

import com.factor.ecommerce.controller.api.ProductController;
import com.factor.ecommerce.model.Product;
import com.factor.ecommerce.persistence.repository.ProductRepository;
import com.factor.ecommerce.services.interfaces.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id, Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Product getProduct(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
