package com.grad.kata9.onemoretry;

import java.util.Map;
import java.util.Map.Entry;

public class TillEngine {

    public Integer calculateTotalPrice(Map<Item, Integer> collectedItems) {
        int total = 0;

        for (Entry<Item, Integer> entry : collectedItems.entrySet()) {
            Item actualItem = entry.getKey();
            total += actualItem.getRule().sumItemPriceAccordingToRule(entry.getValue(), actualItem.getPrice());
        }
        return total;
    }

}
