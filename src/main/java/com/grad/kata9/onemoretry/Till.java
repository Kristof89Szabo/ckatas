package com.grad.kata9.onemoretry;

import java.util.HashMap;
import java.util.Map;

public class Till {

    Map<Item, Integer> collectedItems = new HashMap<>();
    TillEngine tillEngine = new TillEngine();

    public void scanItem(Item item) {
        Integer itemQuantity = collectedItems.getOrDefault(item, 0);
        itemQuantity++;
        collectedItems.put(item, itemQuantity);
    }

    public Integer checkOut() {
        return tillEngine.calculateTotalPrice(collectedItems);

    }
}
