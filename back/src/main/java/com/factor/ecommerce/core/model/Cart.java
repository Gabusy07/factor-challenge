package com.factor.ecommerce.core.model;

import com.factor.ecommerce.auth.model.User;
import com.factor.ecommerce.core.utils.CartType;
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

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CartType cartType;


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOrder> productOrders = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;


    private Cart() {};

    public Integer getId() {
        return id;
    }

    public double getTotalPrice() {
        this.calTotalAmount();
        return totalPrice;
    }

    public void setTotalPrice(Double price) {
        this.totalPrice = price;
    }


    public List<ProductOrder> getProducts() {
        return productOrders;
    }

    public CartType getCartType() {
        return cartType;
    }


    public Boolean getActive() {
        return isActive;
    }

    public void setProductOrders(List<ProductOrder> orders) {
        this.productOrders = orders;
    }

    private void calTotalAmount() {
        double total = 0;
        for (ProductOrder productOrder : productOrders) {
            total += productOrder.getProduct().getPrice();
        }
        this.totalPrice = total;
    }


    public static class Builder {
        private Integer id;
        private double totalPrice;
        private CartType cartType;
        private Boolean isActive;
        private Arrays productOrders;
        private LocalDateTime initialDate;
        private LocalDateTime maxDateAvailable;


        public Cart.Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Cart.Builder setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Cart.Builder setCartType(CartType cartType) {
            this.cartType = cartType;
            return this;
        }

        public Cart.Builder setIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Cart.Builder setInitialDate(LocalDateTime initialDate) {
            this.initialDate = initialDate;
            return this;
        }

        public Cart.Builder setmaxDateAvailable(LocalDateTime maxDateAvailable) {
            this.maxDateAvailable = maxDateAvailable;
            return this;
        }



        public Cart build() {
            Cart cart = new Cart();
            cart.id = this.id;
            cart.totalPrice = this.totalPrice;
            cart.cartType = this.cartType;
            cart.isActive = this.isActive;
            cart.initialDate = initialDate;
            cart.maxDateAvailable = maxDateAvailable;
            return cart;
        }
    }

}