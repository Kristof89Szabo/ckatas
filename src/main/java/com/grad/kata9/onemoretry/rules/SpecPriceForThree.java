package com.grad.kata9.onemoretry.rules;

import static com.grad.kata9.constant.SpecialPricesConstant.A_SPECIAL_PRICE_FOR_THREE;

public class SpecPriceForThree implements Rule {


    public Integer sumItemPriceAccordingToRule(Integer itemQuantity, Integer price) {
        int sum = 0;

        int division = itemQuantity / 3;
        if (division > 0) {
            sum += A_SPECIAL_PRICE_FOR_THREE * division;
        }
        sum += price * (itemQuantity % 3);

        return sum;
    }

}
