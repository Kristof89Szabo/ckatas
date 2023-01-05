package com.grad.kata9.anothertry.rules;

import com.grad.kata9.anothertry.Item;

import java.util.List;
import java.util.stream.Collectors;

import static com.grad.kata9.withrules.constant.SpecialPricesConstant.B_SPECIAL_PRICE_FOR_TWO;

public class SpecPriceForTwo implements Rule {


    private static final String ITEM_NEM_FOR_SPECIAL_PRICE_FOR_TWO = "B";

    @Override
    public Integer sumItemPriceAccordingToRule(List<Item> items) {
        List<Item> filteredItems = filterItems(items);
        int itemQuantity = filteredItems.size();
        int sum = 0;

        int division = itemQuantity / 2;
        if (division > 0) {
            sum += B_SPECIAL_PRICE_FOR_TWO * division;
        }
        sum += filteredItems.get(0).getPrice() * (itemQuantity % 2);
        return sum;
    }

    private List<Item> filterItems(List<Item> items) {
        return items.stream()
                .filter(item -> item.getName().equals(ITEM_NEM_FOR_SPECIAL_PRICE_FOR_TWO))
                .collect(Collectors.toList());
    }
}
