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
    @Column(name = "name", nullable = false, unique = true)
    private String username;

    @Max(50)
    @Min(5)
    @Column(name = "name", nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> cart;

    private User() {}
    private UserType userType = UserType.USER_COMMON;


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

    public static class Builder {
        private Integer id;
        private String username;
        private String password;
        private List<Cart> cart;

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

        public Builder cart(List<Cart> cart) {
            this.cart = cart;
            return this;
        }

        // Método para construir el objeto User
        public User build() {
            User user = new User();
            user.id = this.id;
            user.username = this.username;
            user.password = this.password;
            user.cart = this.cart;
            return user;
        }
    }

    public UserType getUserType() {
        return userType;
    }
}
