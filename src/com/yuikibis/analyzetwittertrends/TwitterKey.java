package com.yuikibis.analyzetwittertrends;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public enum TwitterKey {
    CONSUMER_KEY("*****"),
    CONSUMER_SECRET("*****"),
    ACCESS_TOKEN("*****"),
    ACCESS_TOKEN_SECRET("*****");

    private final String key;

    private static final Configuration configuration;

    TwitterKey(String key) {
        this.key = key;
    }

    static {
        configuration = new ConfigurationBuilder()
                .setOAuthConsumerKey(TwitterKey.CONSUMER_KEY.toString())
                .setOAuthConsumerSecret(TwitterKey.CONSUMER_SECRET.toString())
                .setOAuthAccessToken(TwitterKey.ACCESS_TOKEN.toString())
                .setOAuthAccessTokenSecret(TwitterKey.ACCESS_TOKEN_SECRET.toString())
                .build();
    }

    @Override
    public String toString() {
        return key;
    }

    public static Twitter getTwitterInstance() {
        return new TwitterFactory(configuration).getInstance();
    }

    public static TwitterStream getTwitterStream() {
        return new TwitterStreamFactory(configuration).getInstance();
    }
}