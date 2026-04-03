package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/">Maximum Amount of Money Robot Can Earn</a>
 * <p>
 * You are given an m x n grid. A robot starts at the top-left corner of the grid (0, 0) and wants to reach the bottom-right corner (m - 1, n - 1).
 * The robot can move either right or down at any point in time.
 * <p>
 * The grid contains a value coins[i][j] in each cell:
 * <ul>
 *  <li>If coins[i][j] >= 0, the robot gains that many coins.</li>
 *  <li>If coins[i][j] < 0, the robot encounters a robber, and the robber steals the absolute value of coins[i][j] coins.</li>
 * </ul>
 * The robot has a special ability to neutralize robbers in at most 2 cells on its path, preventing them from stealing coins in those cells.
 * <p>
 * Note: The robot's total coins can be negative.
 * <p>
 * Return the maximum profit the robot can gain on the route.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == coins.length</li>
 *  <li>n == coins[i].length</li>
 *  <li>1 <= m, n <= 500</li>
 *  <li>-1000 <= coins[i][j] <= 1000</li>
 * </ul>
 */
public interface MaximumAmountOfMoneyRobotCanEarn {

    int maximumAmount(int[][] coins);

    class MaximumAmountOfMoneyRobotCanEarnRev1 implements MaximumAmountOfMoneyRobotCanEarn {

        @Override
        public int maximumAmount(int[][] coins) {
            final var m = coins.length;
            final var n = coins[0].length;

            // idea: DP top-down with memoization
            return calc(coins, 0, 0, 2, new Integer[m][n][3]);
        }

        private int calc(int[][] coins, int row, int col, int k, Integer[][][] dp) {
            final var m = coins.length;
            final var n = coins[0].length;

            // base case
            if (row == m - 1 && col == n - 1) {
                return (k == 0) ? coins[row][col] : Math.max(coins[row][col], 0);
            }

            // already solved?
            if (dp[row][col][k] != null) {
                return dp[row][col][k];
            }

            var best = Integer.MIN_VALUE;

            // case #1: don't neutralize
            if (row + 1 < m) {
                best = Math.max(best, coins[row][col] + calc(coins, row + 1, col, k, dp));
            }

            if (col + 1 < n) {
                best = Math.max(best, coins[row][col] + calc(coins, row, col + 1, k, dp));
            }


            // case #2: neutralize
            if (coins[row][col] < 0 && k > 0) {
                if (row + 1 < m) {
                    best = Math.max(best, calc(coins, row + 1, col, k - 1, dp));
                }

                if (col + 1 < n) {
                    best = Math.max(best, calc(coins, row, col + 1, k - 1, dp));
                }
            }

            // cache and return the result
            return dp[row][col][k] = best;
        }
    }
}
