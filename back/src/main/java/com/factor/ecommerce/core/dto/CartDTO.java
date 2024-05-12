package com.factor.ecommerce.core.dto;

import com.factor.ecommerce.core.model.ProductOrder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartDTO {

    private Integer id;
    private Double totalPrice;
    private Boolean isActive;
    private LocalDateTime initialDate;

    private Double totalDiscount;

    private List<ProductOrder> productOrders = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }


    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }


    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", isActive=" + isActive +
                ", initialDate=" + initialDate +
                ", totalDiscount=" + totalDiscount +
                ", productOrders=" + productOrders +
                '}';
    }
}