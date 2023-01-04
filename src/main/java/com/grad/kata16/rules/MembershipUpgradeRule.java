package com.grad.kata16.rules;

import com.grad.kata16.domains.MembershipUpgrade;
import com.grad.kata16.domains.Product;

public class MembershipUpgradeRule extends Rule implements EmailSender {

    @Override
    public void applyRuleOnProduct(Product product) {
        if (product.getClass().equals(MembershipUpgrade.class)) {
            System.out.println("apply the upgrade");
            sendEmailToMembershipOwner();

        }
    }


    @Override
    public void sendEmailToMembershipOwner() {
        System.out.println("email sent about upgrade");
    }
}
