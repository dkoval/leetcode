package com.github.dkoval.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        private static final class Key {
            final int day;
            final boolean buying;

            Key(int day, boolean buying) {
                this.day = day;
                this.buying = buying;
            }

            @Override
            public int hashCode() {
                return Objects.hash(day, buying);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || obj.getClass() != Key.class) {
                    return false;
                }
                Key that = (Key) obj;
                return (day == that.day) && (buying == that.buying);
            }
        }

        @Override
        public int maxProfit(int[] prices, int fee) {
            return maxProfit(prices, fee, 0, true, new HashMap<>());
        }

        private int maxProfit(int[] prices, int fee, int i, boolean buying, Map<Key, Integer> memo) {
            if (i >= prices.length) {
                return 0;
            }

            Key key = new Key(i, buying);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int maxProfitIfSkip = maxProfit(prices, fee, i + 1, buying, memo);
            if (buying) {
                int maxProfitIfBuy = maxProfit(prices, fee, i + 1, false, memo) - prices[i];
                memo.put(key, Math.max(maxProfitIfBuy, maxProfitIfSkip));
            } else {
                int maxProfitIfSell = maxProfit(prices, fee, i + 1, true, memo) + prices[i] - fee;
                memo.put(key, Math.max(maxProfitIfSell, maxProfitIfSkip));
            }
            return memo.get(key);
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
