package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/"> Minimum Cost of Buying Candies With Discount</a>
 * <p>
 * A shop is selling candies at a discount. For every two candies sold, the shop gives a third candy for free.
 * <p>
 * The customer can choose any candy to take away for free as long as the cost of the chosen candy is less than or equal to the minimum cost of the two candies bought.
 * <p>
 * For example, if there are 4 candies with costs 1, 2, 3, and 4, and the customer buys candies with costs 2 and 3, they can take the candy with cost 1 for free, but not the candy with cost 4.
 * <p>
 * Given a 0-indexed integer array cost, where cost[i] denotes the cost of the ith candy, return the minimum cost of buying all the candies.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= cost.length <= 100</li>
 *  <li>1 <= cost[i] <= 100</li>
 * </ul>
 */
public interface MinimumCostOfBuyingCandiesWithDiscount {

    int minimumCost(int[] cost);

    class MinimumCostOfBuyingCandiesWithDiscountRev1 implements MinimumCostOfBuyingCandiesWithDiscount {

        @Override
        public int minimumCost(int[] cost) {
            final var n = cost.length;
            Arrays.sort(cost);

            var total = 0;
            var count = 0;
            for (var i = n - 1; i >= 0; i--) {
                if (count < 2) {
                    total += cost[i];
                    count++;
                } else {
                    count = 0;
                }
            }
            return total;
        }
    }
}
