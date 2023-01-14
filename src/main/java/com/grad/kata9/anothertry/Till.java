package com.grad.kata9.anothertry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Till {

    List<Item> collectedItems = new ArrayList<>();
    TillEngine tillEngine = new TillEngine();

    public void scanItem(Item item) {
        collectedItems.add(item);
    }

    public Integer checkOut() {
        return tillEngine.calculateTotalPrice(collectedItems);
    }
}
