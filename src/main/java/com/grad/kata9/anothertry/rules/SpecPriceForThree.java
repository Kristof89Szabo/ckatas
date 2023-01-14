package com.grad.kata9.anothertry.rules;

import com.grad.kata9.anothertry.Item;

import java.util.List;
import java.util.stream.Collectors;

import static com.grad.kata9.constant.SpecialPricesConstant.A_SPECIAL_PRICE_FOR_THREE;

public class SpecPriceForThree implements Rule {

    private static final String ITEM_NAME_FOR_SPECIAL_PRICE_FOR_THREE = "A";

    @Override
    public Integer sumItemPriceAccordingToRule(List<Item> items) {
        List<Item> filteredList = filterItems(items);
        int itemQuantity = filteredList.size();
        int sum = 0;

        int division = itemQuantity / 3;
        if (division > 0) {
            sum += A_SPECIAL_PRICE_FOR_THREE * division;
        }
        sum += filteredList.get(0).getPrice() * (itemQuantity % 3);

        return sum;
    }

    private List<Item> filterItems(List<Item> items) {
        return items.stream()
                .filter(item -> item.getName().equals(ITEM_NAME_FOR_SPECIAL_PRICE_FOR_THREE))
                .collect(Collectors.toList());
    }

}
