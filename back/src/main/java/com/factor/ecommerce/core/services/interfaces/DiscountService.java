package com.factor.ecommerce.core.services.interfaces;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.core.model.Cart;

public interface DiscountService {
    Double applyDiscount(Cart cart, User user);
}
