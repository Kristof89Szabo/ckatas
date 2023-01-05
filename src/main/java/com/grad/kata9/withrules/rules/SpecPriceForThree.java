package com.grad.kata9.withrules.rules;

import com.grad.kata9.withrules.Item;

import java.util.List;

import static com.grad.kata9.withrules.constant.SpecialPricesConstant.A_SPECIAL_PRICE_FOR_THREE;

public class SpecPriceForThree implements Rule {


    public static Integer sumItemPriceAccordingToRule(List<Item> items) {
        int itemQuantity = items.size();
        int sum = 0;

        int division = itemQuantity / 3;
        if (division > 0) {
            sum += A_SPECIAL_PRICE_FOR_THREE * division;
        }
        sum += items.get(0).getPrice() * (itemQuantity % 3);

        return sum;
    }

}
