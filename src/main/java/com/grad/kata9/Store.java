package com.grad.kata9;

import java.util.Map;

/*
http://codekata.com/kata/kata09-back-to-the-checkout/

 Item   Unit      Special
         Price     Price
  --------------------------
    A     50       3 for 130
    B     30       2 for 45
    C     20
    D     15
 */

public class Store {

    private static final Integer A_UNIT_PRICE = 50;
    private static final Integer B_UNIT_PRICE = 30;
    private static final Integer C_UNIT_PRICE = 20;
    private static final Integer D_UNIT_PRICE = 15;

    private static final Integer A_SPECIAL_PRICE = 130;
    private static final Integer B_SPECIAL_PRICE = 45;

    public static Integer calculateTotalPrice(Map<String, Integer> hMap) {
        int sum = 0;


        for (Map.Entry<String, Integer> e : hMap.entrySet()) {
            if (e.getKey().equals("A")) {
                int division = e.getValue() / 3;
                if (division > 0) {
                    sum += A_SPECIAL_PRICE * division;
                }
                sum += A_UNIT_PRICE * (e.getValue() % 3);
            }

            if (e.getKey().equals("B")) {
                int division = e.getValue() / 2;
                if (division > 0) {
                    sum += B_SPECIAL_PRICE * division;
                }
                sum += B_UNIT_PRICE * (e.getValue() % 2);
            }

            if (e.getKey().equals("C")) {
                sum += C_UNIT_PRICE * e.getValue();
            }

            if (e.getKey().equals("D")) {
                sum += D_UNIT_PRICE * e.getValue();
            }

        }
        return sum;
    }

    public static void addProduct(Map<String, Integer> map, String productName) {
        if (!map.containsKey(productName)) {
            map.put(productName, 1);
        } else {
            int quantity = map.get(productName);
            map.put(productName, ++quantity);
        }
    }


}
