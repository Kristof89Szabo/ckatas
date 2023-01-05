package com.grad.kata9.anothertry;

import com.grad.kata9.anothertry.rules.Rule;
import com.grad.kata9.anothertry.rules.SpecPriceForThree;
import com.grad.kata9.anothertry.rules.SpecPriceForTwo;

import java.util.List;
import java.util.Map;

public class TillEngine {

    List<Rule> rules = List.of(
            new SpecPriceForThree(),
            new SpecPriceForTwo()
    );

    public Integer calculateTotalPrice(List<Item> collectedItems) {
        int total = 0;

        for (Rule rule : rules) {
            total += rule.sumItemPriceAccordingToRule(collectedItems);
        }

        return total;
    }

}
