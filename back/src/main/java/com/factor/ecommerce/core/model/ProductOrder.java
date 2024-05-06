package com.factor.ecommerce.core.model;

import jakarta.persistence.*;


@Entity
public class ProductOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity_order", nullable = false)
    private Integer quantityOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private ProductOrder(){}


    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantityOrder() {
        return quantityOrder;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuantityOrder(Integer quantityOrder) {
        this.quantityOrder = quantityOrder;
    }


    public static class Builder {
        private Integer quantityOrder;
        private Product product;

        public Builder quantityOrder(Integer quantityOrder) {
            this.quantityOrder = quantityOrder;
            return this;
        }

        public Builder product(Product product) {
            this.product = product;
            return this;
        }



        public ProductOrder build() {
            ProductOrder order = new ProductOrder();
            order.quantityOrder = this.quantityOrder;
            order.product = this.product;
            //order.cart = this.cart;
            return order;
        }
    }
}
