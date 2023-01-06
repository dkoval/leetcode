package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-ice-cream-bars/">Maximum Ice Cream Bars</a>
 * <p>
 * It is a sweltering summer day, and a boy wants to buy some ice cream bars.
 * <p>
 * At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins.
 * The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible.
 * <p>
 * Return the maximum number of ice cream bars the boy can buy with coins coins.
 * <p>
 * Note: The boy can buy the ice cream bars in any order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>costs.length == n</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= costs[i] <= 10^5</li>
 *  <li>1 <= coins <= 10^8</li>
 * </ul>
 */
public interface MaximumIceCreamBars {

    int maxIceCream(int[] costs, int coins);

    // O(N * logN) time | O(1) space
    class MaximumIceCreamBarsRev1 implements MaximumIceCreamBars {

        @Override
        public int maxIceCream(int[] costs, int coins) {
            // greedy approach: sort costs[] to let the boy buy the cheapest ice cream bars first
            int n = costs.length;
            Arrays.sort(costs);

            int count = 0;
            for (int i = 0; i < n && coins >= costs[i]; i++) {
                count++;
                coins -= costs[i];
            }
            return count;
        }
    }
}
