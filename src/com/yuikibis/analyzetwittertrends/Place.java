package com.yuikibis.analyzetwittertrends;

public enum Place {
    JAPAN(23424856);

    private final int woeid;

    Place(int woeid) {
        this.woeid = woeid;
    }

    public int getWoeid() {
        return woeid;
    }
}
