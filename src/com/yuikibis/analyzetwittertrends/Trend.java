package com.yuikibis.analyzetwittertrends;

class Trend {
    private final String trend;
    private final int rank;
    private long score;
    private Category category;

    Trend(String trend, int rank) {
        this.trend = trend;
        this.rank = rank;
        this.score = Integer.MAX_VALUE;
    }

    void setScore(long score) {
        this.score = score;
    }

    void setCategory(Category category) {
        this.category = category;
    }

    String getTrend() {
        return trend;
    }

    int getRank() {
        return rank;
    }

    long getScore() {
        return score;
    }

    Category getCategory() {
        return category;
    }
}
