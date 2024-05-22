package com.factor.ecommerce.core.services.impl;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.services.interfaces.DiscountService;
import com.factor.ecommerce.core.services.interfaces.SpecialDateService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
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
        int productCount = cart.getTotalQuantity();

        if(productCount >= 10){
            switch (user.getUserType()) {
                case USER_VIP:
                    double cheaperValueAmountValue = cart.calculateTotalCheapestProductPrice();
                    double bonusCheaperProduct = cheaperValueAmountValue * 0.5; // se bonifica el producto mas barato para aplicar ese descuento
                    totalAmount = totalAmount - VIP_USER_DISCOUNT - bonusCheaperProduct;
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
}*/
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
    public Map<String, Double> applyDiscount(Cart cart, User user) {
        Double totalAmount = cart.getTotalPrice();
        Double discountAmount = 0.0;

        int productCount = cart.getTotalQuantity();

        if(productCount >= 10){
            switch (user.getUserType()) {
                case USER_VIP:
                    double cheaperValueAmountValue = cart.calculateTotalCheapestProductPrice();
                    double bonusCheaperProduct = cheaperValueAmountValue * 0.5;
                    discountAmount = VIP_USER_DISCOUNT + bonusCheaperProduct;
                    break;
                case USER_COMMON:
                    discountAmount = COMMON_USER_DISCOUNT;
                    break;
            }
        } else if (isSpecialDate()) {
            discountAmount = DISCOUNT_SPECIAL_DATE;
        } else if (productCount >= 4) {
            discountAmount = totalAmount * (1 - QUANTITY_BASIC_DISCOUNT_PERCENT);
        }

        totalAmount -= discountAmount;
        totalAmount = Math.max(totalAmount, 0.0);

        Map<String, Double> result = new HashMap<>();
        result.put("discountAmount", discountAmount);
        result.put("totalAmountAfterDiscount", totalAmount);

        return result;
    }
}
