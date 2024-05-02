package com.factor.ecommerce.model;

import com.factor.ecommerce.utils.CartType;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CartType cartType;


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOrder> productOrders;

    private Cart() {};

    public Integer getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
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

    public void calTotalAmount() {
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


        public Cart build() {
            Cart cart = new Cart();
            cart.id = this.id;
            cart.totalPrice = this.totalPrice;
            cart.cartType = this.cartType;
            cart.isActive = this.isActive;
            return cart;
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", chartType=" + cartType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Double.compare(
                cart.totalPrice, totalPrice) == 0 &&
                id.equals(cart.id) &&
                cartType == cart.cartType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPrice, cartType);
    }
}