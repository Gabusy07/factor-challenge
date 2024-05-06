package com.factor.ecommerce.core.dto;

import com.factor.ecommerce.core.model.Product;


public class ProductOrderDTO {

    private Integer quantityOrder;
    private Product product;

    public Integer getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(Integer quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
