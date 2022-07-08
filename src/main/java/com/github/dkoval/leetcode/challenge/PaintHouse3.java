package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/paint-house-iii/">Paint House III (Hard)</a>
 * <p>
 * There is a row of m houses in a small city, each house must be painted with one of the n colors (labeled from 1 to n),
 * some houses that have been painted last summer should not be painted again.
 * <p>
 * A neighborhood is a maximal group of continuous houses that are painted with the same color.
 * <p>
 * For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2}, {3,3}, {2}, {1,1}].
 * Given an array houses, an m x n matrix cost and an integer target where:
 * <p>
 * houses[i]: is the color of the house i, and 0 if the house is not painted yet.
 * cost[i][j]: is the cost of paint the house i with the color j + 1.
 * Return the minimum cost of painting all the remaining houses in such a way that there are exactly target neighborhoods.
 * If it is not possible, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == houses.length == cost.length</li>
 *  <li>n == cost[i].length</li>
 *  <li>1 <= m <= 100</li>
 *  <li>1 <= n <= 20</li>
 *  <li>1 <= target <= m</li>
 *  <li>0 <= houses[i] <= n</li>
 *  <li>1 <= cost[i][j] <= 10^4</li>
 * </ul>
 */
public interface PaintHouse3 {

    int minCost(int[] houses, int[][] cost, int m, int n, int target);

    // O(M * N^2 * T) time | O(M * N * T) space, where T = target
    class PaintHouse3DPTopDown implements PaintHouse3 {

        // Derived from INF > max(cost) * max(m), where m is the number of houses:
        // 10^4 * 100 = 1,000,000
        private static final int INF = 1_000_001;

        @Override
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            // DP top-down
            Integer[][][] memo = new Integer[m][n + 1][target + 1];
            int ans = solve(houses, cost, m, n, target, 0, 0, 0, memo);
            return (ans < INF) ? ans : -1;
        }

        // idx - index of a house we're currently making our decision on
        // lastColor - is used to decide whether we need to start a new neighborhood or not
        // neighborhoods - the number of currently formed neighborhoods
        private int solve(int[] houses, int[][] cost, int m, int n, int target, int idx, int lastColor, int neighborhoods, Integer[][][] memo) {
            if (idx == m) {
                return (neighborhoods == target) ? 0 : INF;
            }

            if (neighborhoods > target) {
                return INF;
            }

            if (memo[idx][lastColor][neighborhoods] != null) {
                return memo[idx][lastColor][neighborhoods];
            }

            if (houses[idx] == 0) {
                // houses[idx] is unpainted -> try every color to choose the one which minimizes the cost of painting
                int ans = INF;
                for (int color = 1; color <= n; color++) {
                    if (color == lastColor) {
                        // join the existing neighborhood
                        ans = Math.min(ans, cost[idx][color - 1] + solve(houses, cost, m, n, target, idx + 1, lastColor, neighborhoods, memo));
                    } else {
                        // start a new neighborhood
                        ans = Math.min(ans, cost[idx][color - 1] + solve(houses, cost, m, n, target, idx + 1, color, neighborhoods + 1, memo));
                    }
                }
                return memo[idx][lastColor][neighborhoods] = ans;
            } else {
                // houses[idx] is painted -> join the existing neighborhood, if possible; or start a new neighborhood otherwise
                int color = houses[idx];
                int ans = (color == lastColor)
                        ? solve(houses, cost, m, n, target, idx + 1, lastColor, neighborhoods, memo)
                        : solve(houses, cost, m, n, target, idx + 1, color, neighborhoods + 1, memo);
                return memo[idx][lastColor][neighborhoods] = ans;
            }
        }
    }
}
