package org.example;



public class Visitor extends Person {
    private boolean hasMembership;
    private String membershipType;

    public Visitor() {
    }

    public Visitor(String name, int age, String gender, boolean hasMembership, String membershipType) {
        super(name, age, gender);
        this.hasMembership = hasMembership;
        this.membershipType = membershipType;
    }

    public boolean isHasMembership() {
        return hasMembership;
    }

    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}

