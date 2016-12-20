package com.yuikibis.analyzetwittertrends;

public class Main {
    public static void main(String[] args) {
        AnalyzeTrends analyzeTrends = new AnalyzeTrends(Place.JAPAN.getWoeid());
        analyzeTrends.analyze();
        analyzeTrends.tweet();
    }
}