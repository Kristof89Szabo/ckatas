package com.grad.kata9.withrules.rules;

import com.grad.kata9.withrules.Item;

import java.util.List;

import static com.grad.kata9.withrules.constant.SpecialPricesConstant.B_SPECIAL_PRICE_FOR_TWO;

public class SpecPriceForTwo implements Rule {


    public static Integer sumItemPriceAccordingToRule(List<Item> items) {
        int itemQuantity = items.size();
        int sum = 0;

            int division = itemQuantity / 2;
            if (division > 0) {
                sum += B_SPECIAL_PRICE_FOR_TWO * division;
            }
        sum += items.get(0).getPrice() * (itemQuantity % 2);
        return sum;
    }
}
