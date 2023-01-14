package com.grad.kata9.onemoretry.rules;

import static com.grad.kata9.constant.SpecialPricesConstant.B_SPECIAL_PRICE_FOR_TWO;

public class SpecPriceForTwo implements Rule {

    public Integer sumItemPriceAccordingToRule(Integer itemQuantity, Integer price) {
        int sum = 0;

        int division = itemQuantity / 2;
        if (division > 0) {
            sum += B_SPECIAL_PRICE_FOR_TWO * division;
        }
        sum += price * (itemQuantity % 2);
        return sum;
    }
}
