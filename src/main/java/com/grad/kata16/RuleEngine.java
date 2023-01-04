package com.grad.kata16;

import com.grad.kata16.domains.Payment;
import com.grad.kata16.rules.BookRule;
import com.grad.kata16.rules.CommissionPaymentRule;
import com.grad.kata16.rules.FirstAidVideoRule;
import com.grad.kata16.rules.MembershipRule;
import com.grad.kata16.rules.MembershipUpgradeRule;
import com.grad.kata16.rules.PhysicalProductRule;
import com.grad.kata16.rules.Rule;

import java.util.List;

public class RuleEngine {

    private final List<Rule> allRules;

    public RuleEngine() {
        this.allRules = List.of(
                new PhysicalProductRule(),
                new BookRule(),
                new MembershipRule(),
                new MembershipUpgradeRule(),
                new FirstAidVideoRule(),
                new CommissionPaymentRule()
        );
    }

    public void applyRule(Payment payment) {
        for (Rule actualRule : allRules) {
            actualRule.applyRuleOnProduct(payment.getProduct());
        }
    }
}
