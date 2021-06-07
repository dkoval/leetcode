package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3770/">Min Cost Climbing Stairs</a>
 * <p>
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost,
 * you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 */
public interface MinCostClimbingStairs {

    int minCostClimbingStairs(int[] cost);

    // O(N) time | O(N) space
    class MinCostClimbingStairsTopDownWithMemoization implements MinCostClimbingStairs {

        @Override
        public int minCostClimbingStairs(int[] cost) {
            Map<Integer, Integer> memo = new HashMap<>();
            return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
        }

        private int minCost(int[] cost, int idx, Map<Integer, Integer> memo) {
            int n = cost.length;
            if (idx > n) {
                return Integer.MAX_VALUE;
            }
            if (idx == n) {
                return 0;
            }

            if (memo.containsKey(idx)) {
                return memo.get(idx);
            }

            int totalCost = cost[idx] + Math.min(minCost(cost, idx + 1, memo), minCost(cost, idx + 2, memo));
            memo.put(idx, totalCost);
            return totalCost;
        }
    }

    // O(N) time | O(N) space
    class MinCostClimbingStairsBottomUp implements MinCostClimbingStairs {

        @Override
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            // dp[i] denotes the total cost to climb to the i-th step
            int[] dp = new int[n + 1];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i <= n; i++) {
                dp[i] = ((i < n) ? cost[i] : 0) + Math.min(dp[i - 1], dp[i - 2]);
            }
            return dp[n];
        }
    }

    // O(N) time | O(1) space
    class MinCostClimbingStairsBottomUpSpaceOptimized implements MinCostClimbingStairs {

        @Override
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int first = cost[0];
            int second = cost[1];

            for (int i = 2; i <= n; i++) {
                int third = ((i < n) ? cost[i] : 0) + Math.min(first, second);
                first = second;
                second = third;
            }
            return second;
        }
    }
}
