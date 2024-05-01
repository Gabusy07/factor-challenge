package com.factor.ecommerce.controller.request;


public class ProductItemRequest {

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

        public ProductItemRequest.Builder quantityOrder(Integer quantityOrder) {
            this.quantityOrder = quantityOrder;
            return this;
        }

        public ProductItemRequest.Builder productId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public ProductItemRequest.Builder cartId(Integer cartId) {
            this.cartId = cartId;
            return this;
        }

        public ProductItemRequest build() {
            ProductItemRequest pr = new ProductItemRequest();
            pr.quantityOrder = this.quantityOrder;
            pr.productId = this.productId;
            pr.cartId = this.cartId;
            return pr;
        }
    }
}
