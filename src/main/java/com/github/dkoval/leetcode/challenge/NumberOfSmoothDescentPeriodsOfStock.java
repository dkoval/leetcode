package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/">Number of Smooth Descent Periods of a Stock</a>
 * <p>
 * You are given an integer array prices representing the daily price history of a stock, where prices[i] is the stock price on the ith day.
 * <p>
 * A smooth descent period of a stock consists of one or more contiguous days such that the price on each day is lower than the price on the preceding day by exactly 1.
 * The first day of the period is exempted from this rule.
 * <p>
 * Return the number of smooth descent periods.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= prices.length <= 10^5</li>
 *  <li>1 <= prices[i] <= 10^5</li>
 * </ul>
 */
public interface NumberOfSmoothDescentPeriodsOfStock {

    long getDescentPeriods(int[] prices);

    class NumberOfSmoothDescentPeriodsOfStockRev1 implements NumberOfSmoothDescentPeriodsOfStock {

        @Override
        public long getDescentPeriods(int[] prices) {
            final var n = prices.length;

            var total = 1L;
            var streak = 1;
            for (var i = 1; i < n; i++) {
                if (prices[i - 1] == prices[i] + 1) {
                    streak++;
                } else {
                    streak = 1;
                }
                total += streak;
            }
            return total;
        }
    }
}
