package com.grad.kata16;

import com.grad.kata16.domains.Book;
import com.grad.kata16.domains.Membership;
import com.grad.kata16.domains.MembershipUpgrade;
import com.grad.kata16.domains.Payment;
import com.grad.kata16.domains.Video;

public class Main {

    public static void main(String[] args) {
        RuleEngine engine = new RuleEngine();

        Payment payment1 = new Payment(new Book(1500));
        Payment payment2 = new Payment(new Video(4000, true, "Die Hard"));
        Payment payment3 = new Payment(new Membership(10000, 1234));
        Payment payment4 = new Payment(new MembershipUpgrade(10000, 1234));
        Payment payment5 = new Payment(new Video(2000, true, "Learning to Ski"));

        engine.applyRule(payment1);
        System.out.println("_______________________________");
        engine.applyRule(payment2);
        System.out.println("_______________________________");
        engine.applyRule(payment3);
        System.out.println("_______________________________");
        engine.applyRule(payment4);
        System.out.println("_______________________________");
        engine.applyRule(payment5);
    }

}
