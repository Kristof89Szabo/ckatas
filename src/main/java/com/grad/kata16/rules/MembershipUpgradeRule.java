package com.grad.kata16.rules;

import com.grad.kata16.domains.MembershipUpgrade;
import com.grad.kata16.domains.Product;

public class MembershipUpgradeRule extends Rule {

    EmailSenderService emailSenderService = new EmailSenderService();

    @Override
    public void applyRuleOnProduct(Product product) {
        if (product.getClass().equals(MembershipUpgrade.class)) {
            System.out.println("apply the upgrade");
            sendEmailToMembershipOwner();

        }
    }

    public void sendEmailToMembershipOwner() {
        emailSenderService.sendEmailToMembershipOwner("email sent about upgrade");
    }
}
