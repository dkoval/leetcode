package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        // O(N) time | O(1) space
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

            int maxProfitIfCooldown = maxProfit(prices, i + 1, buying, memo);
            if (buying) {
                int maxProfitIfBuy = maxProfit(prices, i + 1, false, memo) - prices[i];
                memo.put(key, Math.max(maxProfitIfBuy, maxProfitIfCooldown));
            } else {
                // i = i + 2, because after buying a stock you have to cooldown on the next day
                int maxProfitIfSell = maxProfit(prices, i + 2, true, memo) + prices[i];
                memo.put(key, Math.max(maxProfitIfSell, maxProfitIfCooldown));
            }
            return memo.get(key);
        }
    }
}
