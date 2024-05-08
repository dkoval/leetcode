package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/relative-ranks/">Relative Ranks</a>
 * <p>
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
 * All the scores are guaranteed to be unique.
 * <p>
 * The athletes are placed based on their scores, where the 1st place athlete has the highest score,
 * the 2nd place athlete has the 2nd highest score, and so on.
 * The placement of each athlete determines their rank:
 * <ul>
 *  <li>The 1st place athlete's rank is "Gold Medal".</li>
 *  <li>The 2nd place athlete's rank is "Silver Medal".</li>
 *  <li>The 3rd place athlete's rank is "Bronze Medal".</li>
 * </ul>
 * For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
 * Return an array answer of size n where answer[i] is the rank of the ith athlete.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == score.length</li>
 *  <li>1 <= n <= 10^4</li>
 *  <li>0 <= score[i] <= 10^6</li>
 *  <li>All the values in score are unique.</li>
 * </ul>
 */
public interface RelativeRanks {

    String[] findRelativeRanks(int[] score);

    // O(N*logN) time | O(N) space
    class RelativeRanksRev1 implements RelativeRanks {

        @Override
        public String[] findRelativeRanks(int[] score) {
            int n = score.length;

            int[] scoreCopy = Arrays.copyOf(score, n);
            Arrays.sort(scoreCopy);

            // All the scores are guaranteed to be unique
            Map<Integer, Integer> scoreToIndex = new HashMap<>();
            for (int i = 0; i < n; i++) {
                // indices of scores sorted in desc order
                scoreToIndex.put(scoreCopy[i], n - i - 1);
            }

            String[] ans = new String[n];
            for (int i = 0; i < n; i++) {
                ans[i] = translate(scoreToIndex.get(score[i]));
            }
            return ans;
        }

        private String translate(int index) {
            return switch (index) {
                case 0 -> "Gold Medal";
                case 1 -> "Silver Medal";
                case 2 -> "Bronze Medal";
                default -> String.valueOf(index + 1);
            };
        }
    }
}
