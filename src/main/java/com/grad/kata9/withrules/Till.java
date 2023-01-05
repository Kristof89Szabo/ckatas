package com.grad.kata9.withrules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Till {

    Map<String, List<Item>> collectedItems = new HashMap<>();
    TillEngine tillEngine = new TillEngine();

    public void scanItem(Item item) {
        List<Item> itemsFromMap = collectedItems.getOrDefault(item.name, new ArrayList<>());
        itemsFromMap.add(item);
        collectedItems.put(item.name, itemsFromMap);
    }

    public Integer checkOut() {
        return tillEngine.calculateTotalPrice(collectedItems);

    }
}
