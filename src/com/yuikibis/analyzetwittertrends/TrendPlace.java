package com.yuikibis.analyzetwittertrends;

public enum TrendPlace {
    Japan(23424856);

    private int id;

    TrendPlace(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
