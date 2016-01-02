package com.yuikibis.analyzetwittertrends;

import twitter4j.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalyzeTwitter {
    private final Twitter twitter;

    AnalyzeTwitter() {
        twitter = TwitterKey.getTwitterInstance();
    }

    private long getScore(String string) throws TwitterException {
        Query query = new Query();
        query.setQuery(string);
        QueryResult result = twitter.search(query);
        List<Status> tweets = result.getTweets();
        Status first = tweets.get(0);
        Status last = tweets.get(tweets.size() - 1);
        return first.getCreatedAt().getTime() - last.getCreatedAt().getTime();
    }

    private String analyzeTrend(TrendModel trend) {
        try {
            for (AnalyzeCategory category : AnalyzeCategory.values()) {
                long score = getScore(trend.getTrend() + " " + category.toString());
                if (trend.getScore() > score) {
                    trend.setScore(score);
                    trend.setCategory(category);
                }
            }
            return "[" + trend.getRank() + "位] " + trend.getTrend() + " => " + trend.getCategory() + "?";
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<TrendModel> getTrendModels(int location) {
        Trend[] trends = new Trend[0];
        try {
            trends = twitter.getPlaceTrends(location).getTrends();
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        List<TrendModel> trendModels = new ArrayList<>();
        for (int i = 0; i < trends.length; i++) {
            Trend trend = trends[i];
            trendModels.add(new TrendModel(trend.getName(), i + 1));
        }
        return trendModels;
    }

    public void tweet(String text) {
        try {
            twitter.updateStatus(text);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    public String analyze(int location, int start, int end) {
        List<TrendModel> trendModels = getTrendModels(location);

        if (start < 0 || start > end || trendModels.size() < end) {
            throw new IllegalArgumentException();
        }

        String result = "トレンド解析\n";
        result += "分類 " + Arrays.asList(AnalyzeCategory.values()) + "\n";

        for (int i = start; i < end; i++) {
            TrendModel trend = trendModels.get(i);
            result += analyzeTrend(trend) + "\n";
        }

        return result;
    }
}
