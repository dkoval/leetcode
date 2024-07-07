package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/water-bottles/">Water Bottles</a>
 * <p>
 * There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles
 * from the market with one full water bottle.
 * <p>
 * The operation of drinking a full water bottle turns it into an empty bottle.
 * <p>
 * Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= numBottles <= 100</li>
 *  <li>2 <= numExchange <= 100</li>
 * </ul>
 */
public interface WaterBottles {

    int numWaterBottles(int numBottles, int numExchange);

    class WaterBottlesRev1 implements WaterBottles {

        @Override
        public int numWaterBottles(int numBottles, int numExchange) {
            int count = numBottles;
            int numEmptyBottles = numBottles;
            while (numEmptyBottles >= numExchange) {
                int numRefilledBottles = numEmptyBottles / numExchange;
                count += numRefilledBottles;
                // prepare for the next iteration
                numEmptyBottles %= numExchange;
                numEmptyBottles += numRefilledBottles;
            }
            return count;
        }
    }

    class WaterBottlesRev2 implements WaterBottles {

        @Override
        public int numWaterBottles(int numBottles, int numExchange) {
            int ans = 0;
            int numEmpty = 0;
            while (numBottles > 0) {
                // drink all full water bottles
                ans += numBottles;
                numEmpty += numBottles;
                // exchange empty water bottles
                numBottles = numEmpty / numExchange;
                numEmpty %= numExchange;
            }
            return ans;
        }
    }
}
