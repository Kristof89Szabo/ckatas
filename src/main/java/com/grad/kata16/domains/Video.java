package com.grad.kata16.domains;

public class Video extends Product {

    private String title;

    public Video(Integer price, boolean isPhysicalProduct, String title) {
        super(price, isPhysicalProduct);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
