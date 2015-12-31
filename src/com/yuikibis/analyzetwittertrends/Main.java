package com.yuikibis.analyzetwittertrends;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        AnalyzeTwitter analyzeTwitter = new AnalyzeTwitter();
        String result = analyzeTwitter.analyze(TrendPlace.Japan.getId(), start, end);
        analyzeTwitter.tweet(result);
    }
}
