package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/">Best Time to Buy and Sell Stock IV</a>
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= k <= 100</li>
 *  <li>0 <= prices.length <= 1000</li>
 *  <li>0 <= prices[i] <= 1000</li>
 * </ul>
 */
public interface BestTimeToBuyAndSellStock4 {

    int maxProfit(int k, int[] prices);

    // O(N * K) time | O(N * K) space
    class BestTimeToBuyAndSellStock4DPTopDown implements BestTimeToBuyAndSellStock4 {

        @Override
        public int maxProfit(int k, int[] prices) {
            // DP: top-down
            int n = prices.length;
            // memo[day][k][0] - max profit we can make when buying on that day with at most k transactions left
            // memo[day][k][1] - max profit we can make when selling on that day with at most k transactions left
            return buy(prices, 0, k, new Integer[n + 1][k + 1][2]);
        }

        // What is the max profit we can make when buying a stock on that day with at most k transactions left?
        private int buy(int[] prices, int day, int k, Integer[][][] memo) {
            if (day == prices.length) {
                return 0;
            }

            if (memo[day][k][0] != null) {
                return memo[day][k][0];
            }

            int maxProfitBuyingToday = Integer.MIN_VALUE;
            if (k > 0) {
                // if we buy today, we can sell again in the future
                maxProfitBuyingToday = sell(prices, day + 1, k - 1, memo) - prices[day];
            }

            // if we don't buy today, we can still do so on another day in the future
            int maxProfitNotBuyingToday = buy(prices, day + 1, k, memo);

            // cache and return the result
            return memo[day][k][0] = Math.max(maxProfitBuyingToday, maxProfitNotBuyingToday);
        }

        // Given we own a stock, what is the max profit we can make when selling a stock on that day with at most k transactions left?
        private int sell(int[] prices, int day, int k, Integer[][][] memo) {
            if (day == prices.length) {
                return 0;
            }

            if (memo[day][k][1] != null) {
                return memo[day][k][1];
            }

            // if we sell today, we can buy again in the future
            int maxProfitSellingToday = buy(prices, day + 1, k, memo) + prices[day];

            // if we don't sell today, we can still do so on another day in the future
            int maxProfitNotSellingToday = sell(prices, day + 1, k, memo);

            // cache and return the result
            return memo[day][k][1] = Math.max(maxProfitSellingToday, maxProfitNotSellingToday);
        }
    }
}
