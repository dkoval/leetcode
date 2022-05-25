package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/russian-doll-envelopes/">Russian Doll Envelopes</a>
 * <p>
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 * <p>
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 * <p>
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * <p>
 * Note: You cannot rotate an envelope.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= envelopes.length <= 10^5</li>
 *  <li>envelopes[i].length == 2</li>
 *  <li>1 <= wi, hi <= 10^5</li>
 * </ul>
 */
public interface RussianDollEnvelopes {

    int maxEnvelopes(int[][] envelopes);

    class RussianDollEnvelopesTLE implements RussianDollEnvelopes {

        // O(N^2) time | O(N) space
        // Correct but results with TLE on Leetcode
        @Override
        public int maxEnvelopes(int[][] envelopes) {
            // ~ the longest increasing subsequence DP problem
            int n = envelopes.length;
            // sort envelopes by their width in asc order
            Arrays.sort(envelopes, Comparator.comparingInt(envelop -> envelop[0]));

            // dp[i] - is the length of the longest increasing subsequence ending at i
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            int best = 1;
            for (int i = 0; i < n; i++) {
                // can we extend previous subsequences with envelopes[i]?
                for (int j = i - 1; j >= 0; j--) {
                    // width and height of envelopers[i] bust be greater than those of envelopes[j]
                    if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                best = Math.max(best, dp[i]);
            }
            return best;
        }
    }
}
