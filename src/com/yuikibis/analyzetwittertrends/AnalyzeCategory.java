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

    public static String getEnumeration() {
        String enumeration = "[";
        for (AnalyzeCategory category : AnalyzeCategory.values()) {
            enumeration += category.toString() + ", ";
        }
        enumeration = enumeration.substring(0, enumeration.length() - 2);
        enumeration += "]";
        return enumeration;
    }
}
