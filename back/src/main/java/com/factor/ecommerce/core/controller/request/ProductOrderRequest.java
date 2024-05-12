package com.factor.ecommerce.core.controller.request;


public class ProductOrderRequest {

    private Integer quantityOrder;

    private Integer productId;

    private Integer cartId;


    public Integer getQuantityOrder() {
        return quantityOrder;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getCartId() {
        return cartId;
    }



    public static class Builder {

        private Integer quantityOrder;
        private Integer productId;
        private Integer cartId;



        public ProductOrderRequest.Builder quantityOrder(Integer quantityOrder) {
            this.quantityOrder = quantityOrder;
            return this;
        }

        public ProductOrderRequest.Builder productId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public ProductOrderRequest.Builder cartId(Integer cartId) {
            this.cartId = cartId;
            return this;
        }

        public ProductOrderRequest build() {
            ProductOrderRequest pr = new ProductOrderRequest();
            pr.quantityOrder = this.quantityOrder;
            pr.productId = this.productId;
            pr.cartId = this.cartId;
            return pr;
        }
    }
}
