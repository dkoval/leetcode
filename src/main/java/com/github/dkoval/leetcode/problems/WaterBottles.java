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
            var total = numBottles;
            var emptyBottles = numBottles;
            while (emptyBottles >= numExchange) {
                final var fullBottles = emptyBottles / numExchange;
                total += fullBottles;
                // prepare for the next iteration
                emptyBottles %= numExchange;
                emptyBottles += fullBottles;
            }
            return total;
        }
    }

    class WaterBottlesRev2 implements WaterBottles {

        @Override
        public int numWaterBottles(int numBottles, int numExchange) {
            var total = 0;
            var numEmpty = 0;
            while (numBottles > 0) {
                // drink all full water bottles
                total += numBottles;
                numEmpty += numBottles;
                // exchange empty water bottles
                numBottles = numEmpty / numExchange;
                numEmpty %= numExchange;
            }
            return total;
        }
    }
}
