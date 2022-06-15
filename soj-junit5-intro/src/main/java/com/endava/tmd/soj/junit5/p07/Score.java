package com.endava.tmd.soj.junit5.p07;

import java.util.concurrent.atomic.AtomicInteger;

public class Score {
    private AtomicInteger correctAnswers = new AtomicInteger();
    private AtomicInteger incorrectAnswers = new AtomicInteger();

    public Score addCorrectAnswer() {
        correctAnswers.incrementAndGet();
        return this;
    }

    public Score addIncorrectAnswer() {
        incorrectAnswers.incrementAndGet();
        return this;
    }

    public String getPercent() {
        int correct = correctAnswers.get();
        int incorrect = incorrectAnswers.get();
        int total = correct + incorrect;

        double percent = total == 0 ? 100 : 100.0 * correct / total;
        return String.format("%.1f", percent);
    }
}
