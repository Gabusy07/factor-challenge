package com.factor.ecommerce.core.model;

import com.factor.ecommerce.auth.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "carts")
public class Cart{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "initial_date", nullable = false)
    private LocalDateTime initialDate;

    @Column(name = "max_date_available", nullable = false)
    private LocalDateTime maxDateAvailable;


    @JsonIgnore
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductOrder> productOrders = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    public Integer getId() {
        return id;
    }

    public double getTotalPrice() {
        this.totalPrice = this.calTotalAmount();
        return totalPrice;
    }

    public void setTotalPrice(Double price) {
        this.totalPrice = price;
    }


    public List<ProductOrder> getOrders() {
        return productOrders;
    }




    public Boolean getActive() {
        return isActive;
    }

    public void setProductOrders(List<ProductOrder> orders) {
        this.productOrders = orders;
    }

    private double calTotalAmount() {
        double totalPrice = 0.0;
        if (productOrders != null) {
            for (ProductOrder order : productOrders) {
                totalPrice += order.getQuantityOrder() * order.getProduct().getPrice();
            }
        }
        return totalPrice;
    }

    public double calculateTotalCheapestProductPrice() {
        if (productOrders == null || productOrders.isEmpty()) {
            return 0.0;
        }

        double cheapestPrice = Double.MAX_VALUE;
        Product cheapestProduct = null;
        for (ProductOrder order : productOrders) {
            double price = order.getProduct().getPrice();
            if (price < cheapestPrice) {
                cheapestPrice = price;
                cheapestProduct = order.getProduct();
            }
        }
        if (cheapestProduct == null) {
            return 0.0;
        }

        double total = 0.0;
        for (ProductOrder order : productOrders) {
            if (order.getProduct().equals(cheapestProduct)) {
                total += cheapestPrice * order.getQuantityOrder();
                break; // Solo necesitamos calcular el total de una orden
            }
        }

        return total;
    }


    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public Integer getTotalQuantity() {
        int totalQuantity = 0;
        if (productOrders != null) {
            for (ProductOrder order : productOrders) {
                totalQuantity += order.getQuantityOrder();
            }
        }
        return totalQuantity;
    }

    public LocalDateTime getMaxDateAvailable() {
        return maxDateAvailable;
    }

    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public User getUser() {
        return user;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public static class Builder {
        private Cart cart;

        public Builder() {
            cart = new Cart();
        }

        public Builder id(Integer id) {
            cart.id = id;
            return this;
        }

        public Builder totalPrice(double totalPrice) {
            cart.totalPrice = totalPrice;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            cart.isActive = isActive;
            return this;
        }

        public Builder initialDate(LocalDateTime initialDate) {
            cart.initialDate = initialDate;
            return this;
        }

        public Builder maxDateAvailable(LocalDateTime maxDateAvailable) {
            cart.maxDateAvailable = maxDateAvailable;
            return this;
        }

        public Builder productOrders(List<ProductOrder> productOrders) {
            cart.productOrders = productOrders;
            return this;
        }

        public Builder user(User user) {
            cart.user = user;
            return this;
        }

        public Cart build() {
            return cart;
        }
    }

}
