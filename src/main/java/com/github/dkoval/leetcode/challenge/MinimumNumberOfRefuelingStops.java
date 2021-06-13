package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3776/">Minimum Number of Refueling Stops</a>
 * <p>
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 * <p>
 * Along the way, there are gas stations. Each station[i] represents a gas station that is station[i][0] miles east of
 * the starting position, and has station[i][1] liters of gas.
 * <p>
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
 * It uses 1 liter of gas per 1 mile that it drives.
 * <p>
 * When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
 * <p>
 * What is the least number of refueling stops the car must make in order to reach its destination?
 * If it cannot reach the destination, return -1.
 * <p>
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
 * If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 */
public interface MinimumNumberOfRefuelingStops {

    int minRefuelStops(int target, int startFuel, int[][] stations);

    // O(N^2) time | O(N) space
    class MinimumNumberOfRefuelingStopsBottomUpInQuadraticTime implements MinimumNumberOfRefuelingStops {

        @Override
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            int n = stations.length;
            // dp[i] denotes the farthest location we can get to using i refueling stops
            int[] dp = new int[n + 1];
            dp[0] = startFuel;
            for (int i = 1; i < n; i++) {
                // if we reached stations[i][0] location with j refueling stops,
                // we can now reach stations[i][1] extra miles further with j + 1 refueling stops
                for (int j = i; j >= 0; j--) {
                    int currLocation = stations[i][0];
                    if (dp[j] >= currLocation) {
                        int extraFuel = stations[i][1];
                        dp[j + 1] = Math.max(dp[j + 1], dp[j] + extraFuel);
                    }
                }
            }

            for (int i = 0; i <= n; i++) {
                if (dp[i] >= target) {
                    return i;
                }
            }
            return -1;
        }
    }
}
