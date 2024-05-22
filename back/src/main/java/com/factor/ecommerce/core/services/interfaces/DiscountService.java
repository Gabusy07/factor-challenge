package com.factor.ecommerce.core.services.interfaces;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.core.model.Cart;

import java.util.Map;

public interface DiscountService {
    Map<String, Double> applyDiscount(Cart cart, User user);
}
