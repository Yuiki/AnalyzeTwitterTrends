package com.yuikibis.analyzetwittertrends;

public enum Category {
    GAKITSUKA("ガキ使"),
    KOHAKU("紅白"),
    KAKUTOGI("格闘技");

    private final String category;

    Category(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}
