package com.grad.kata16.domains;

public class Membership extends Product {

    private Integer membershipId;
    private boolean isActive;
    private MembershipLevel membershipLevel;

    public Membership(Integer price, Integer membershipId) {
        super(price, false);
        this.membershipId = membershipId;
    }

    public Integer getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(Integer membershipId) {
        this.membershipId = membershipId;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
