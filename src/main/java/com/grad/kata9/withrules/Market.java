package com.grad.kata9.withrules;

public class Market {


    public static void main(String[] args) {
        Till till = new Till();
        Item item1 = new Item("A", 50);
        Item item2 = new Item("A", 50);
        Item item3 = new Item("A", 50);
        Item item4 = new Item("B", 30);
        Item item5 = new Item("B", 30);
        Item item6 = new Item("C", 20);

        till.scanItem(item1);
        till.scanItem(item2);
        till.scanItem(item3);
        till.scanItem(item4);
        till.scanItem(item5);
        till.scanItem(item6);

        Integer totalPrice = till.checkOut();
        System.out.println(totalPrice);
    }


}
