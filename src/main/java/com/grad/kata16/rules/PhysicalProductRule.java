package com.grad.kata16.rules;

import com.grad.kata16.domains.Product;

public class PhysicalProductRule extends Rule {

    public void applyRuleOnProduct(Product product) {
        if (product.isPhysicalProduct()) {
            System.out.println("Generate a packing slip for shipping.");
        }
    }
}
