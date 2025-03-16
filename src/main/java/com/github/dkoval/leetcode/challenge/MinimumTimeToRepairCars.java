package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-time-to-repair-cars/">Minimum Time to Repair Cars</a>
 * <p>
 * You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic.
 * A mechanic with a rank r can repair n cars in r * n^2 minutes.
 * <p>
 * You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
 * <p>
 * Return the minimum time taken to repair all the cars.
 * <p>
 * Note: All the mechanics can repair the cars simultaneously.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= ranks.length <= 10^5</li>
 *  <li>1 <= ranks[i] <= 100</li>
 *  <li>1 <= cars <= 10^6</li>
 * </ul>
 */
public interface MinimumTimeToRepairCars {

    long repairCars(int[] ranks, int cars);

    class MinimumTimeToRepairCarsRev1 implements MinimumTimeToRepairCars {

        @Override
        public long repairCars(int[] ranks, int cars) {
            // Guess the answer using binary search
            // Condition: Given time T and the ranks of some mechanics, is it enough repair all the cars?
            // FF...FTT...T
            //       ^ answer
            // 1 <= ranks[i] <= 100
            var left = 1L;
            var right = 100L * cars * cars;
            while (left < right) {
                var mid = left + (right - left) / 2;
                if (good(ranks, cars, mid)) {
                    // mid may be the answer;
                    // check if there's a better alternative to the left of it
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean good(int[] ranks, int cars, long time) {
            // The time it takes to fix n cars for a mechanic with rank r:
            // r * n ^ 2 = t
            // => n = sqrt(t / r)
            var count = 0L;
            for (var rank : ranks) {
                count += (long) Math.sqrt(1.0 * time / rank);
            }
            return count >= cars;
        }
    }
}
