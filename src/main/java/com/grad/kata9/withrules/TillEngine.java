package com.grad.kata9.withrules;

import com.grad.kata9.withrules.rules.SpecPriceForThree;
import com.grad.kata9.withrules.rules.SpecPriceForTwo;

import java.util.List;
import java.util.Map;

public class TillEngine {

    public Integer calculateTotalPrice(Map<String, List<Item>> collectedItems) {
        int total = 0;


//        FIXME Hosszu tavon nem managelheto
        for (Map.Entry<String, List<Item>> entry : collectedItems.entrySet()) {
            String productName = entry.getKey();
            if (productName.equals("A")) {
                total += SpecPriceForThree.sumItemPriceAccordingToRule(entry.getValue());
            } else if (productName.equals("B")) {
                total += SpecPriceForTwo.sumItemPriceAccordingToRule(entry.getValue());
            } else {
                total += entry.getValue().get(0).price * entry.getValue().size();
            }
        }
        return total;
    }

}
