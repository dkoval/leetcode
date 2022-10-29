package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/earliest-possible-day-of-full-bloom/">Earliest Possible Day of Full Bloom (Hard)</a>
 * <p>
 * You have n flower seeds. Every seed must be planted first before it can begin to grow, then bloom.
 * Planting a seed takes time and so does the growth of a seed. You are given two 0-indexed integer arrays plantTime and growTime, of length n each:
 * <p>
 * plantTime[i] is the number of full days it takes you to plant the ith seed. Every day, you can work on planting exactly one seed.
 * You do not have to work on planting the same seed on consecutive days, but the planting of a seed is not complete
 * until you have worked plantTime[i] days on planting it in total.
 * <p>
 * growTime[i] is the number of full days it takes the ith seed to grow after being completely planted.
 * After the last day of its growth, the flower blooms and stays bloomed forever.
 * From the beginning of day 0, you can plant the seeds in any order.
 * <p>
 * Return the earliest possible day where all seeds are blooming.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == plantTime.length == growTime.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>1 <= plantTime[i], growTime[i] <= 10^4</li>
 * </ul>
 */
public interface EarliestPossibleDayOfFullBloom {

    int earliestFullBloom(int[] plantTime, int[] growTime);

    // O(N*logN) time | O(N) space
    class EarliestPossibleDayOfFullBloomRev1 implements EarliestPossibleDayOfFullBloom {

        @Override
        public int earliestFullBloom(int[] plantTime, int[] growTime) {
            int n = plantTime.length;

            // sort seeds by their growTime in DESC order (because while seeds[i] is growing, we can focus on planting another seed j)
            PlantGrowTime[] seeds = new PlantGrowTime[n];
            for (int i = 0; i < n; i++) {
                seeds[i] = new PlantGrowTime(plantTime[i], growTime[i]);
            }

            Arrays.sort(seeds, Comparator.comparingInt(seed -> -seed.growTime));

            // P - plantTime, G - growTime
            //
            // |-- P1 --| ----- G1 ----- |
            //          ^
            //          | --- P2 --- | --- G2 --- |
            //                       ^
            //                       | - P3 - | -- G2 -- |
            //                                ^         ^^^
            //                            current time   latest (the earliest possible day on which all seeds are blooming)
            int currTime = 0;
            int latest = 0;
            for (int i = 0; i < n; i++) {
                currTime += seeds[i].plantTime;
                latest = Math.max(latest, currTime + seeds[i].growTime);
            }
            return latest;
        }

        private static class PlantGrowTime {
            final int plantTime;
            final int growTime;

            PlantGrowTime(int plantTime, int growTime) {
                this.plantTime = plantTime;
                this.growTime = growTime;
            }
        }
    }
}
