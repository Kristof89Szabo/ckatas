package com.grad.kata9.onemoretry;

import com.grad.kata9.onemoretry.rules.Rule;
import com.grad.kata9.onemoretry.rules.SpecPriceForThree;
import com.grad.kata9.onemoretry.rules.SpecPriceForTwo;

public class Market {


    public static void main(String[] args) {
        Rule r3 = new SpecPriceForThree();
        Rule r2 = new SpecPriceForTwo();
        Till till = new Till();
        Item item1 = new Item("A", 50, r3);
        Item item2 = new Item("A", 50, r3);
        Item item3 = new Item("A", 50, r3);

        Item item4 = new Item("B", 30, r2);
        Item item5 = new Item("B", 30, r2);

        till.scanItem(item1);
        till.scanItem(item2);
        till.scanItem(item3);
        till.scanItem(item4);
        till.scanItem(item5);


        Integer totalPrice = till.checkOut();
        System.out.println(totalPrice);
    }


}
