package com.yuikibis.analyzetwittertrends;

import twitter4j.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AnalyzeTrends {
    private final Twitter twitter = Key.getTwitterInstance();

    private String result;
    private int woeid;

    AnalyzeTrends(int woeid) {
        this.woeid = woeid;
    }

    private long getScore(String string) {
        Query query = new Query(string);
        QueryResult result = null;
        try {
            result = twitter.search(query);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        if (result != null) {
            List<Status> tweets = result.getTweets();
            if (tweets.size() == 0) {
                return Long.MAX_VALUE;
            }
            Status firstTweet = tweets.get(0);
            Status lastTweet = tweets.get(tweets.size() - 1);
            return firstTweet.getCreatedAt().getTime() - lastTweet.getCreatedAt().getTime();
        }
        return Long.MAX_VALUE;
    }

    private String analyzeTrend(Trend trend) {
        for (Category category : Category.values()) {
            long currentScore = getScore(trend.getTrend() + " " + category.toString());
            if (trend.getScore() > currentScore) {
                trend.setScore(currentScore);
                trend.setCategory(category);
            }
        }
        return "[" + trend.getRank() + "位] " + trend.getTrend() + " => " + trend.getCategory() + "?";
    }

    private List<Trend> getTrends() {
        twitter4j.Trend[] T4JTrends = null;
        try {
            T4JTrends = twitter.getPlaceTrends(woeid).getTrends();
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        List<Trend> trends = new ArrayList<>();
        if (T4JTrends != null) {
            for (int i = 0; i < T4JTrends.length; i++) {
                twitter4j.Trend trend = T4JTrends[i];
                trends.add(new Trend(trend.getName(), i + 1));
            }
        }
        return trends;
    }

    void tweet() {
        if (result == null) {
            throw new IllegalStateException();
        }
        try {
            twitter.updateStatus(result);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    void analyze() {
        result = "トレンド解析\n";
        result += "分類 " + Arrays.asList(Category.values()) + "\n";

        List<Trend> trends = getTrends().subList(0, 10);
        for (Trend trend : trends) {
            result += analyzeTrend(trend) + "\n";
        }
    }
}