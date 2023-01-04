package com.grad.kata16.domains;

public abstract class Product {

    private Integer price;
    private boolean isPhysicalProduct;

    public Product(Integer price, boolean isPhysicalProduct) {
        this.price = price;
        this.isPhysicalProduct = isPhysicalProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isPhysicalProduct() {
        return isPhysicalProduct;
    }

    public void setPhysicalProduct(boolean physicalProduct) {
        isPhysicalProduct = physicalProduct;
    }
}
