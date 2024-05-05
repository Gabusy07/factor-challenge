package com.factor.ecommerce.auth.model;

import com.factor.ecommerce.core.model.Cart;
import com.factor.ecommerce.core.model.ProductOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;
import com.factor.ecommerce.auth.utils.UserType;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Max(25)
    @Min(6)
    @Email
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;


    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    private User() {}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
    }

    public static class Builder {
        private Integer id;
        private String username;
        private String password;
        private Cart cart;
        private UserType userType;

        public Builder() {}

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public void setId(Integer id) {
            this.id = id;
        }


        public Builder cart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public User build() {
            User user = new User();
            user.id = this.id;
            user.username = this.username;
            user.password = this.password;
            user.cart = this.cart;
            user.userType = this.userType;
            return user;
        }
    }

    public UserType getUserType() {
        return userType;
    }
}
