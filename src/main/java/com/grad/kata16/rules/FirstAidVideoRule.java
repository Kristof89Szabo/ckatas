package com.grad.kata16.rules;

import com.grad.kata16.domains.Product;
import com.grad.kata16.domains.Video;

public class FirstAidVideoRule extends Rule{

    @Override
    public void applyRuleOnProduct(Product product) {
        if (product.getClass().equals(Video.class) && ((Video) product).getTitle().equals("Learning to Ski")){
            System.out.println("Add a free “First Aid” video to the packing slip (the result of a court decision in 1997)");
        }
    }
}
