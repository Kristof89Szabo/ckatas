package com.grad.kata16.domains;

public class MembershipUpgrade extends Product{

    private Integer membershipId;

    public MembershipUpgrade(Integer price, Integer membershipId) {
        super(price, false);
        this.membershipId = membershipId;
    }

    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }
}
