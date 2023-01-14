package com.grad.kata9.onemoretry;

import com.grad.kata9.onemoretry.rules.Rule;

import java.util.Objects;

public class Item {

    private String name;
    private Integer price;
    private Rule rule;


    public Item(String name, Integer price, Rule rule) {
        this.name = name;
        this.price = price;
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(price, item.price) && Objects.equals(rule, item.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, rule);
    }
}
