package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-to-acquire-required-items/">Minimum Cost to Acquire Required Items</a>
 * <p>
 * You are given five integers cost1, cost2, costBoth, need1, and need2.
 * <p>
 * There are three types of items available:
 * <p>
 * An item of type 1 costs cost1 and contributes 1 unit to the type 1 requirement only.
 * <p>
 * An item of type 2 costs cost2 and contributes 1 unit to the type 2 requirement only.
 * <p>
 * An item of type 3 costs costBoth and contributes 1 unit to both type 1 and type 2 requirements.
 * <p>
 * You must collect enough items so that the total contribution toward type 1 is at least need1 and the total contribution toward type 2 is at least need2.
 * <p>
 * Return an integer representing the minimum possible total cost to achieve these requirements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= cost1, cost2, costBoth <= 10^6</li>
 *  <li>0 <= need1, need2 <= 10^9</li>
 * </ul>
 */
public interface MinimumCostToAcquireRequiredItems {

    long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2);

    // O(1) time | O(1) space
    class MinimumCostToAcquireRequiredItemsRev1 implements MinimumCostToAcquireRequiredItems {

        @Override
        public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
            // type 3 vs individual type 1 and type 2 items
            final var limit = Math.min(need1, need2);
            var total = limit * (long) Math.min(costBoth, cost1 + cost2);

            // remaining type 1 items
            final var rem1 = need1 - limit;
            total += rem1 * (long) Math.min(cost1, costBoth);

            // remaining type 2 items
            final var rem2 = need2 - limit;
            total += rem2 * (long) Math.min(cost2, costBoth);

            return total;
        }
    }
}
