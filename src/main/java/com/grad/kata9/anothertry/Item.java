package com.grad.kata9.anothertry;

public class Item {

    String name;
    Integer price;

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
