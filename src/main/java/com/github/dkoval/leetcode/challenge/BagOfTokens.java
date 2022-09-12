package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/bag-of-tokens//">Bag of Tokens</a>
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
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= tokens.length <= 1000</li>
 *  <li>0 <= tokens[i], power < 10^4</li>
 * </ul>
 */
public interface BagOfTokens {

    int bagOfTokensScore(int[] tokens, int power);

    // O(N*logN) time | O(1) space
    class BagOfTokensGreedy implements BagOfTokens {

        public int bagOfTokensScore(int[] tokens, int power) {
            int n = tokens.length;

            // sort tokens in ASC order
            Arrays.sort(tokens);

            int left = 0;
            int right = n - 1;
            int score = 0;
            int maxScore = 0;
            while (left <= right) {
                if (power >= tokens[left]) {
                    // when playing a token face up, we want to minimize lost units of power, therefore
                    // we choose tokens[left]
                    power -= tokens[left];
                    score++;
                    maxScore = Math.max(maxScore, score);
                    left++;
                } else if (score >= 1) {
                    // when playing a token face down, we want to maximize gained units of power, therefore
                    // we choose tokens[right]
                    power += tokens[right];
                    score--;
                    maxScore = Math.max(maxScore, score);
                    right--;
                } else {
                    // can't play anymore
                    return maxScore;
                }
            }
            return maxScore;
        }
    }
}
