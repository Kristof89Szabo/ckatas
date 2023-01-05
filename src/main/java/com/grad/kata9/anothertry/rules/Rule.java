package com.grad.kata9.anothertry.rules;

import com.grad.kata9.anothertry.Item;

import java.util.List;

public interface Rule {

    Integer sumItemPriceAccordingToRule(List<Item> items);

}
