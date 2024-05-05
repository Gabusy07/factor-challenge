package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.services.interfaces.DiscountService;
import com.factor.ecommerce.core.services.interfaces.SpecialDateService;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final SpecialDateService specialDateService;

    private static final Double COMMON_USER_DISCOUNT = 100.0;
    private static final Double VIP_USER_DISCOUNT = 500.0;
    private static final Double DISCOUNT_SPECIAL_DATE = 300.0;
    private static final Double QUANTITY_BASIC_DISCOUNT_PERCENT = 0.75;

    public DiscountServiceImpl(SpecialDateService specialDateService) {
        this.specialDateService = specialDateService;
    }

    private Boolean isSpecialDate() {
        return specialDateService.isASpecialDate();
    }


    @Override
    public Double applyDiscount(Cart cart, User user) {
        Double totalAmount = cart.getTotalPrice();
        int productCount = cart.getProducts().size();

        if(productCount >= 10){
            switch (user.getUserType()) {
                case USER_VIP:
                    //TODO bonificar el producto mas barato
                    totalAmount -= VIP_USER_DISCOUNT;
                    break;
                case USER_COMMON:
                    totalAmount -= COMMON_USER_DISCOUNT;
                    break;
            }
        } else if (isSpecialDate()) {
            totalAmount -= DISCOUNT_SPECIAL_DATE;
            
        } else if (productCount >= 4) {
            totalAmount *= QUANTITY_BASIC_DISCOUNT_PERCENT;
        }

        totalAmount = Math.max(totalAmount, 0.0);

        return totalAmount;
    }
}
