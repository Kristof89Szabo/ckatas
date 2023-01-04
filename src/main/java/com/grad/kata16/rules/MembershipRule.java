package com.grad.kata16.rules;

import com.grad.kata16.domains.Membership;
import com.grad.kata16.domains.Product;

public class MembershipRule extends Rule implements EmailSender {

    public void applyRuleOnProduct(Product product) {

        if (product.getClass().equals(Membership.class)) {
            System.out.println("Activate that membership.");
            sendEmailToMembershipOwner();
        }
    }
    @Override
    public void sendEmailToMembershipOwner() {
        System.out.println("sent email about active status");
    }
}
