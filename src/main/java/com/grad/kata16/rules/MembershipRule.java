package com.grad.kata16.rules;

import com.grad.kata16.domains.Membership;
import com.grad.kata16.domains.Product;

public class MembershipRule extends Rule {

    EmailSenderService emailSenderService = new EmailSenderService();

    public void applyRuleOnProduct(Product product) {

        if (product.getClass().equals(Membership.class)) {
            System.out.println("Activate that membership.");
            sendEmailToMembershipOwner();
        }
    }

    public void sendEmailToMembershipOwner() {
        emailSenderService.sendEmailToMembershipOwner("Sent email about active status");
    }
}
