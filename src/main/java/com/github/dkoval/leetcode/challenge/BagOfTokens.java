package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/featured/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3506/">Bag of Tokens</a>
 * <p>
 * You have an initial power of P, an initial score of 0, and a bag of tokens where tokens[i] is the value of
 * the ith token (0-indexed).
 * <p>
 * Your goal is to maximize your total score by potentially playing each token in one of two ways:
 * <ul>
 *     <li>If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1 score.</li>
 *     <li>If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.</li>
 * </ul>
 * <p>
 * Each token may be played at most once and in any order. You do not have to play all the tokens.
 * <p>
 * Return the largest possible score you can achieve after playing any number of tokens.
 */
public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int power = P;
        int i = 0, j = tokens.length - 1;
        int score = 0, maxScore = 0;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                maxScore = Math.max(maxScore, score);
                i++;

            } else if (score > 0) {
                power += tokens[j];
                score--;
                j--;
            } else {
                return maxScore;
            }
        }
        return maxScore;
    }
}
