package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/</a>
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public interface BestTimeToBuyAndSellStock3 {

    int maxProfit(int[] prices);

    // Resource: https://www.youtube.com/watch?v=0FKn0FSIQYE
    // O(N) time | O(N) space
    class BestTimeToBuyAndSellStock3DPBottomUp implements BestTimeToBuyAndSellStock3 {

        @Override
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if (n < 2) {
                return 0;
            }

            // maxProfitLeft[i] is the maximum profit in prices[0:i] prefix
            int[] maxProfitLeft = new int[n];
            // the minimum price in prices[0:i] prefix
            int minPriceLeft = prices[0];

            // maxProfitRight[i] is the maximum profit in prices[i:] suffix
            int[] maxProfitRight = new int[n];
            // the maximum price in prices[i:] suffix
            int maxPriceRight = prices[n - 1];

            for (int i = 1; i < n; i++) {
                // iterate from 1 till n - 1
                maxProfitLeft[i] = Math.max(maxProfitLeft[i - 1], prices[i] - minPriceLeft);
                minPriceLeft = Math.min(minPriceLeft, prices[i]);

                // iterate from n - 2 down to 0
                int j = n - i - 1;
                maxProfitRight[j] = Math.max(maxProfitRight[j + 1], maxPriceRight - prices[j]);
                maxPriceRight = Math.max(maxPriceRight, prices[j]);
            }

            int maxProfit = 0;
            for (int i = 0; i < n; i++) {
                maxProfit = Math.max(maxProfit, maxProfitLeft[i] + maxProfitRight[i]);
            }
            return maxProfit;
        }
    }
}
