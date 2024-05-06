package com.factor.ecommerce.core.persistence.repository;

import com.factor.ecommerce.core.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("FROM Cart c WHERE c.isActive=true AND user.id=:userId")
    Optional<Cart> findActiveByUserId(Integer userId);
}
