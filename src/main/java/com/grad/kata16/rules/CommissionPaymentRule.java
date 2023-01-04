package com.grad.kata16.rules;

import com.grad.kata16.domains.Book;
import com.grad.kata16.domains.Product;

public class CommissionPaymentRule extends Rule {


    @Override
    public void applyRuleOnProduct(Product product) {
        if (product.getClass().equals(Book.class) || product.isPhysicalProduct()) {
            System.out.println("generate a commission payment to the agent.");
        }
    }
}
