package com.factor.ecommerce.model;

import com.factor.ecommerce.utils.CartType;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

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


    @ManyToMany
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    private Cart() {};

    public Integer getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public Set<Product> getProducts() {
        return products;
    }

    public CartType getCartType() {
        return cartType;
    }


    public Boolean getActive() {
        return isActive;
    }

    public static class Builder {
        private Integer id;
        private double totalPrice;
        private CartType cartType;
        private Boolean isActive;


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