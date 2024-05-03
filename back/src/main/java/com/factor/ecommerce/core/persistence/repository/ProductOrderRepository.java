package com.factor.ecommerce.core.persistence.repository;

import com.factor.ecommerce.core.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
