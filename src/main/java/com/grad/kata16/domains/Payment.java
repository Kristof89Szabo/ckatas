package com.grad.kata16.domains;

public class Payment {

    private Product product;

    public Payment(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
