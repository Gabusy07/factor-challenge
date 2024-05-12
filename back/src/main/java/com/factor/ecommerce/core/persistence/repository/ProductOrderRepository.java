package com.factor.ecommerce.core.persistence.repository;

import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.Product;
import com.factor.ecommerce.core.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
    Optional<ProductOrder> findByCartAndProduct(Cart cart, Product product);
}
