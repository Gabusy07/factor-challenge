package com.factor.ecommerce.model;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "products")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "code", nullable = true, length = 25)
    private String code;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "image", nullable = true, length = 300)
    private String image;

    /*
    @ManyToMany(mappedBy = "products")
    private Set<Cart> carts;*/

    private Product() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    /*
    public Set<Cart> getCarts() {
        return carts;
    }*/

    public boolean increaseQuantity(Short amount) {
        if (amount < 0) {
            return false;
        }
        this.quantity += amount;
        return true;
    }

    public boolean decreaseQuantity(Short amount) {
        if (amount < 0 || amount > this.quantity) {
            return false;
        }
        this.quantity -= amount;
        return true;
    }

    public static class Builder {

        private Integer id;
        private String name;
        private Integer quantity;
        private String code;
        private Double price;
        private String image;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.id = this.id;
            product.name = this.name;
            product.quantity = this.quantity;
            product.code = this.code;
            product.price = this.price;
            product.image = this.image;
            return product;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && name.equals(product.name) &&
                quantity.equals(product.quantity) &&
                code.equals(product.code) &&
                price.equals(product.price) &&
                image.equals(product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, code, price, image);
    }
}