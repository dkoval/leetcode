package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">Best Time to Buy and Sell Stock with Cooldown</a>
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= prices.length <= 5000</li>
 *  <li>0 <= prices[i] <= 1000</li>
 * </ul>
 */
public interface BestTimeToBuyAndSellStockWithCooldown {

    int maxProfit(int[] prices);

    class BestTimeToBuyAndSellStockWithCooldownDPTopDown implements BestTimeToBuyAndSellStockWithCooldown {

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

        // O(N) time | O(N) space
        // Resource: https://www.youtube.com/watch?v=I7j0F7AHpb8&t=6s
        @Override
        public int maxProfit(int[] prices) {
            return maxProfit(prices, 0, true, new HashMap<>());
        }

        private int maxProfit(int[] prices, int i, boolean buying, Map<Key, Integer> memo) {
            if (i >= prices.length) {
                return 0;
            }

            Key key = new Key(i, buying);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int maxProfitIfSkip = maxProfit(prices, i + 1, buying, memo);
            if (buying) {
                int maxProfitIfBuy = maxProfit(prices, i + 1, false, memo) - prices[i];
                memo.put(key, Math.max(maxProfitIfBuy, maxProfitIfSkip));
            } else {
                // i = i + 2, because after selling a stock you have to cooldown on the next day
                int maxProfitIfSell = maxProfit(prices, i + 2, true, memo) + prices[i];
                memo.put(key, Math.max(maxProfitIfSell, maxProfitIfSkip));
            }
            return memo.get(key);
        }
    }

    class BestTimeToBuyAndSellStockWithCooldownDPTopDownRemastered implements BestTimeToBuyAndSellStockWithCooldown {

        // O(N) time | O(N) space
        // Resource: https://www.youtube.com/watch?v=uQpvL4fFRAU
        @Override
        public int maxProfit(int[] prices) {
            int n = prices.length;
            return buy(prices, 0, new Integer[n], new Integer[n]);
        }

        private int buy(int[] prices, int day, Integer[] buyMemo, Integer[] sellMemo) {
            if (day >= prices.length) {
                return 0;
            }

            if (buyMemo[day] != null) {
                return buyMemo[day];
            }

            // option #1: don't buy a stock on this day
            int maxProfitIfSkip = buy(prices, day + 1, buyMemo, sellMemo);
            // option #2: buy a stock on this day
            int maxProfitIfBuy = sell(prices, day + 1, buyMemo, sellMemo) - prices[day];
            // cache and return
            return buyMemo[day] = Math.max(maxProfitIfSkip, maxProfitIfBuy);
        }

        private int sell(int[] prices, int day, Integer[] buyMemo, Integer[] sellMemo) {
            if (day >= prices.length) {
                return 0;
            }

            if (sellMemo[day] != null) {
                return sellMemo[day];
            }

            // option #1: don't sell a stock on this day
            int maxProfitIfSkip = sell(prices, day + 1, buyMemo, sellMemo);
            // option #2: sell a stock on this day; day = day + 2, because after selling a stock you have to cooldown on the next day
            int maxProfitIfSell = buy(prices, day + 2, buyMemo, sellMemo) + prices[day];
            // cache and return
            return sellMemo[day] = Math.max(maxProfitIfSkip, maxProfitIfSell);
        }
    }
}
