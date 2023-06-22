package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">Best Time to Buy and Sell Stock with Transaction Fee</a>
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * <p>
 * Note: You may not engage in multiple transaction.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= prices.length <= 5 * 10^4</li>
 *  <li>1 <= prices[i] < 5 * 10^4</li>
 *  <li>0 <= fee < 5 * 10^4</li>
 * </ul>
 */
public interface BestTimeToBuyAndSellStockWithTransactionFee {

    int maxProfit(int[] prices, int fee);

    // O(N) time | O(N) space
    class BestTimeToBuyAndSellStockWithTransactionFeeDPTopDown implements BestTimeToBuyAndSellStockWithTransactionFee {

        @Override
        public int maxProfit(int[] prices, int fee) {
            // idea: DP
            int n = prices.length;

            // dp[i][0] - the maximum profit a one can achieve if BUY on the i-th day
            // dp[i][1] - the maximum profit a one can achieve if SELL on the i-th day
            Integer[][] dp = new Integer[n][2];
            return calculate(prices, fee, 0, true, dp);
        }

        private int calculate(int[] prices, int fee, int day, boolean buy, Integer[][] dp) {
            int n = prices.length;

            // base case
            if (day >= n) {
                return 0;
            }

            int mode = buy ? 0 : 1;

            // already solved?
            if (dp[day][mode] != null) {
                return dp[day][mode];
            }

            // option #1: skip this day
            int best = calculate(prices, fee, day + 1, buy, dp);
            if (buy) {
                // option #2: buy on this day
                best = Math.max(best, calculate(prices, fee, day + 1, false, dp) - prices[day]);
            } else {
                // option #1: sell on this day
                best = Math.max(best, calculate(prices, fee, day + 1, true, dp) + prices[day] - fee);
            }

            // cache and return the answer
            return dp[day][mode] = best;
        }
    }

    // O(N) time | O(1) space
    class BestTimeToBuyAndSellStockWithTransactionFeeDPBottomUp implements BestTimeToBuyAndSellStockWithTransactionFee {
        @Override
        public int maxProfit(int[] prices, int fee) {
            int buying = 0, selling = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                buying = Math.max(buying, selling + prices[i] - fee);
                selling = Math.max(selling, buying - prices[i]);
            }
            return buying;
        }
    }
}
