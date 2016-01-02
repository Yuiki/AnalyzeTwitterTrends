package com.yuikibis.analyzetwittertrends;

public enum AnalyzeCategory {
    GAKITSUKA("ガキ使"),
    KOHAKU("紅白"),
    KAKUTOGI("格闘技");

    private String category;

    AnalyzeCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}
