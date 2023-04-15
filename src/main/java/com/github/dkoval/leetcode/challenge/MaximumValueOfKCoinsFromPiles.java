package com.github.dkoval.leetcode.challenge;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/">Maximum Value of K Coins From Piles (Hard)</a>
 * <p>
 * There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.
 * <p>
 * In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.
 * <p>
 * Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom,
 * and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == piles.length</li>
 *  <li>1 <= n <= 1000</li>
 *  <li>1 <= piles[i][j] <= 10^5</li>
 *  <li>1 <= k <= sum(piles[i].length) <= 2000</li>
 * </ul>
 */
public interface MaximumValueOfKCoinsFromPiles {

    int maxValueOfCoins(List<List<Integer>> piles, int k);

    // O(P * K) time, where P - total number of coins
    // O(N * K) space
    class MaximumValueOfKCoinsFromPilesDPTopDown implements MaximumValueOfKCoinsFromPiles {

        @Override
        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            int n = piles.size();

            // DP top-down
            // dp[i][j] - maximum total value of coins you can get with i piles and j coins
            Integer[][] dp = new Integer[n][k + 1];
            return getMaxValue(piles, 0, k, dp);
        }

        private int getMaxValue(List<List<Integer>> piles, int i, int k, Integer[][] dp) {
            int n = piles.size();

            if (i == n) {
                return 0;
            }

            if (k == 0) {
                return 0;
            }

            if (dp[i][k] != null) {
                return dp[i][k];
            }

            // option #1: skip the i-th pile
            int best = getMaxValue(piles, i + 1, k, dp);

            // option #2: take x top coins from the i-th pile, then proceed to the next pile
            int total = 0;
            for (int top = 0; top < Math.min(piles.get(i).size(), k); top++) {
                total += piles.get(i).get(top);
                best = Math.max(best, total + getMaxValue(piles, i + 1, k - top - 1, dp));
            }

            // cache & return the answer
            return dp[i][k] = best;
        }
    }
}
