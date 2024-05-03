package com.factor.ecommerce.core.persistence.repository;

import com.factor.ecommerce.core.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
