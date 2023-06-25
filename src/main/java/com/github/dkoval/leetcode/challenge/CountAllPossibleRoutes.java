package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-all-possible-routes/">Count All Possible Routes (Hard)</a>
 * <p>
 * You are given an array of distinct positive integers locations where locations[i] represents the position of city i.
 * You are also given integers start, finish and fuel representing the starting city, ending city, and the initial amount of fuel you have, respectively.
 * <p>
 * At each step, if you are at city i, you can pick any city j such that j != i and 0 <= j < locations.length and move to city j.
 * Moving from city i to city j reduces the amount of fuel you have by |locations[i] - locations[j]|. Please notice that |x| denotes the absolute value of x.
 * <p>
 * Notice that fuel cannot become negative at any point in time, and that you are allowed to visit any city more than once (including start and finish).
 * <p>
 * Return the count of all possible routes from start to finish. Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= locations.length <= 100</li>
 *  <li>1 <= locations[i] <= 10^9</li>
 *  <li>All integers in locations are distinct.</li>
 *  <li>0 <= start, finish < locations.length</li>
 *  <li>1 <= fuel <= 200</li>
 * </ul>
 */
public interface CountAllPossibleRoutes {

    int MOD = 1_000_000_007;

    int countRoutes(int[] locations, int start, int finish, int fuel);

    // O(N^2 * F) time | O(N * F) space
    class CountAllPossibleRoutesRev1 implements CountAllPossibleRoutes {

        @Override
        public int countRoutes(int[] locations, int start, int finish, int fuel) {
            // Idea: brute force with memoization => DP top-down
            int n = locations.length;

            // dp[i][x] - the number of all possible routes from city i to finish given x amount of fuel
            Integer[][] dp = new Integer[n][fuel + 1];
            return calculate(locations, start, finish, fuel, dp);
        }

        private int calculate(int[] locations, int i, int finish, int fuel, Integer[][] dp) {
            // already solved?
            if (dp[i][fuel] != null) {
                return dp[i][fuel];
            }

            int n = locations.length;
            int count = 0;
            if (i == finish) {
                count++;
            }

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }

                int dist = Math.abs(locations[i] - locations[j]);
                if (fuel - dist >= 0) {
                    count += calculate(locations, j, finish, fuel - dist, dp);
                    count %= MOD;
                }
            }
            return dp[i][fuel] = count;
        }
    }
}
