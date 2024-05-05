package com.factor.ecommerce.core.model;

import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "products")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @Column(name = "code", nullable = true, length = 25)
    private String code;
    @Column(name = "price", nullable = true)
    private Double price;
    @Column(name = "image", nullable = true, length = 300)
    private String image;


    private Product() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getStock() {
        return stock;
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

    public String getDescription() {
        return description;
    }

    public boolean increaseStock(Integer amount) {
        if (amount < 0) {
            return false;
        }
        this.stock += amount;
        return true;
    }

    public boolean decreaseStock(Integer amount) {
        if (amount < 0 || amount > this.stock) {
            return false;
        }
        this.stock -= amount;
        return true;
    }

    public static class Builder {
        private Integer id;
        private String name;
        private Integer stock;
        private String code;
        private Double price;
        private String image;

        private String description;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStock(Integer stock) {
            this.stock = stock;
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

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.id = this.id;
            product.name = this.name;
            product.stock = this.stock;
            product.code = this.code;
            product.price = this.price;
            product.image = this.image;
            product.description = this.description;
            return product;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + stock +
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
                stock.equals(product.stock) &&
                code.equals(product.code) &&
                price.equals(product.price) &&
                image.equals(product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stock, code, price, image);
    }
}