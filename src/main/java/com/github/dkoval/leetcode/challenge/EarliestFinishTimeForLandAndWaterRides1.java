package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/">Earliest Finish Time for Land and Water Rides I</a>
 * <p>
 * You are given two categories of theme park attractions: land rides and water rides.
 * <p>
 * Land rides
 * <p>
 * landStartTime[i] – the earliest time the ith land ride can be boarded.
 * landDuration[i] – how long the ith land ride lasts.
 * <p>
 * Water rides
 * <p>
 * waterStartTime[j] – the earliest time the jth water ride can be boarded.
 * waterDuration[j] – how long the jth water ride lasts.
 * A tourist must experience exactly one ride from each category, in either order.
 * <p>
 * A ride may be started at its opening time or any later moment.
 * <p>
 * If a ride is started at time t, it finishes at time t + duration.
 * <p>
 * Immediately after finishing one ride the tourist may board the other (if it is already open) or wait until it opens.
 * <p>
 * Return the earliest possible time at which the tourist can finish both rides.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n, m <= 100</li>
 *  <li>landStartTime.length == landDuration.length == n</li>
 *  <li>waterStartTime.length == waterDuration.length == m</li>
 *  <li>1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <= 1000</li>
 * </ul>
 */
public interface EarliestFinishTimeForLandAndWaterRides1 {

    int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration);

    class EarliestFinishTimeForLandAndWaterRides1Rev1 implements EarliestFinishTimeForLandAndWaterRides1 {

        @Override
        public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
            final var n = landStartTime.length;
            final var m = waterStartTime.length;

            var best = Integer.MAX_VALUE;
            for (var i = 0; i < n; i++) {
                for (var j = 0; j < m; j++) {
                    final var t1 = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j];
                    final var t2 = Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i];
                    best = Math.min(best, t1);
                    best = Math.min(best, t2);
                }
            }
            return best;
        }
    }
}
