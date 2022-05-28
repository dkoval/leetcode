package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">Min Cost Climbing Stairs</a>
 * <p>
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost,
 * you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= cost.length <= 1000</li>
 *  <li>0 <= cost[i] <= 999</li>
 * </ul>
 */
public interface MinCostClimbingStairs {

    int minCostClimbingStairs(int[] cost);

    // O(N) time | O(N) space
    class MinCostClimbingStairsDPTopDown implements MinCostClimbingStairs {

        @Override
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            Integer[] memo = new Integer[n];
            return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
        }

        // Min cost to reach the top of the floor from idx
        private int minCost(int[] cost, int idx, Integer[] memo) {
            int n = cost.length;

            if (idx > n) {
                return Integer.MAX_VALUE;
            }

            if (idx == n) {
                return 0;
            }

            if (memo[idx] != null) {
                return memo[idx];
            }

            int totalCost = cost[idx] + Math.min(minCost(cost, idx + 1, memo), minCost(cost, idx + 2, memo));
            return memo[idx] = totalCost;
        }
    }

    // O(N) time | O(N) space
    class MinCostClimbingStairsDPBottomUpRev1 implements MinCostClimbingStairs {

        @Override
        public int minCostClimbingStairs(int[] cost) {
            return Math.min(minCost(cost, 0), minCost(cost, 1));
        }

        private int minCost(int[] cost, int start) {
            int n = cost.length;

            // dp[i] is the min cost to get to i from start
            int[] dp = new int[n + 2];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[start] = 0;

            for (int i = start; i < n; i++) {
                // cost to get to (i + 1) and (i + 2) from i
                int totalCost = dp[i] + cost[i];

                // take 1 step from i
                dp[i + 1] = Math.min(dp[i + 1], totalCost);
                // take 2 steps from i
                dp[i + 2] = Math.min(dp[i + 2], totalCost);
            }
            return dp[n];
        }
    }

    // O(N) time | O(N) space
    class MinCostClimbingStairsDPBottomUpRev2 implements MinCostClimbingStairs {

        @Override
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;

            // dp[i] is the min cost if starting from i
            int[] dp = new int[n];
            dp[0] = cost[0];
            dp[1] = cost[1];

            for (int i = 2; i < n; i++) {
                // we can reach to i from either (i - 1) or (i - 2) step, which one is better
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
            return Math.min(dp[n - 1], dp[n - 2]);
        }
    }

    // O(N) time | O(1) space
    class MinCostClimbingStairsBottomUpRev2SpaceOptimized implements MinCostClimbingStairs {

        @Override
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;

            // dp[i] is the min cost if starting from i
            int first = cost[0];
            int second = cost[1];

            for (int i = 2; i < n; i++) {
                // we can reach to i from either (i - 1) or (i - 2) step, which one is better
                int third = cost[i] + Math.min(first, second);
                first = second;
                second = third;
            }
            return Math.min(first, second);
        }
    }
}
