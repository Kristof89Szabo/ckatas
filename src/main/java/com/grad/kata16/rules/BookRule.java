package com.grad.kata16.rules;

import com.grad.kata16.domains.Book;
import com.grad.kata16.domains.Product;

public class BookRule extends Rule {

    public void applyRuleOnProduct(Product product) {
        if (product.getClass().equals(Book.class)) {
            System.out.println("Create a duplicate packing slip for the royalty department.");
        }
    }
}
