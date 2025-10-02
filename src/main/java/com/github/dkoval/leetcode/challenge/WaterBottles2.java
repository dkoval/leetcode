package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/water-bottles-ii/">Watter Bottles II</a>
 * <p>
 * You are given two integers numBottles and numExchange.
 * <p>
 * numBottles represents the number of full water bottles that you initially have. In one operation, you can perform one of the following operations:
 * <ul>
 *  <li>Drink any number of full water bottles turning them into empty bottles.</li>
 *  <li>Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.</li>
 * </ul>
 * Note that you cannot exchange multiple batches of empty bottles for the same value of numExchange.
 * For example, if numBottles == 3 and numExchange == 1, you cannot exchange 3 empty water bottles for 3 full bottles.
 * <p>
 * Return the maximum number of water bottles you can drink.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= numBottles <= 100</li>
 *  <li>1 <= numExchange <= 100</li>
 * </ul>
 */
public interface WaterBottles2 {

    int maxBottlesDrunk(int numBottles, int numExchange);

    class WaterBottles2Rev1 implements WaterBottles2 {

        @Override
        public int maxBottlesDrunk(int numBottles, int numExchange) {
            var total = numBottles;
            var emptyBottles = numBottles;
            var fullBottles = 0;
            while (fullBottles > 0 || emptyBottles >= numExchange) {
                if (fullBottles > 0) {
                    // drink all full bottles
                    total += fullBottles;
                    emptyBottles += fullBottles;
                    fullBottles = 0;
                } else {
                    // exchange numExchange empty bottles for 1 full bottle
                    emptyBottles -= numExchange;
                    fullBottles++;
                    numExchange++;
                }
            }
            return total;
        }
    }
}
