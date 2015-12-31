package com.yuikibis.analyzetwittertrends;

public class TrendModel {
    private final String trend;
    private final int rank;
    private long score;
    private AnalyzeCategory category;

    TrendModel(String trend, int rank) {
        this.trend = trend;
        this.rank = rank;
        this.score = Integer.MAX_VALUE;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public void setCategory(AnalyzeCategory category) {
        this.category = category;
    }

    public String getTrend() {
        return trend;
    }

    public int getRank() {
        return rank;
    }

    public long getScore() {
        return score;
    }

    public AnalyzeCategory getCategory() {
        return category;
    }
}
