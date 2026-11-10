package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs-ii/">Climbing Stairs II</a>
 * <p>
 * You are climbing a staircase with n + 1 steps, numbered from 0 to n.
 * <p>
 * You are also given a 1-indexed integer array costs of length n, where costs[i] is the cost of step i.
 * <p>
 * From step i, you can jump only to step i + 1, i + 2, or i + 3. The cost of jumping from step i to step j is defined as: costs[j] + (j - i)^2
 * <p>
 * You start from step 0 with cost = 0.
 * <p>
 * Return the minimum total cost to reach step n.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == costs.length <= 10^5</li>
 *  <li>1 <= costs[i] <= 10^4</li>
 * </ul>
 */
public interface ClimbingStairs2 {

    int climbStairs(int n, int[] costs);

    class ClimbingStairs2Rev1 implements ClimbingStairs2 {

        @Override
        public int climbStairs(int n, int[] costs) {
            // dp[i] is the minimum cost to reach step i
            final var dp = new int[n + 1];
            dp[0] = 0;

            for (var j = 1; j <= n; j++) {
                dp[j] = Integer.MAX_VALUE;
                for (var shift = 1; shift <= 3; shift++) {
                    final var i = j - shift;
                    if (i >= 0) {
                        dp[j] = Math.min(dp[j], dp[i] + cost(costs, i, j));
                    }
                }
            }
            return dp[n];
        }

        private int cost(int[] costs, int i, int j) {
            return costs[j - 1] + (j - i) * (j - i);
        }
    }

    class ClimbingStairs2Rev2 implements ClimbingStairs2 {

        @Override
        public int climbStairs(int n, int[] costs) {
            // DP top-down
            return calc(n, costs, 0, new Integer[n + 1]);
        }

        private int calc(int n, int[] costs, int index, Integer[] dp) {
            // base case
            if (index >= n) {
                return 0;
            }

            // already solved?
            if (dp[index] != null) {
                return dp[index];
            }

            var best = Integer.MAX_VALUE;
            for (var step = 1; step <= 3; step++) {
                if (index + step <= n) {
                    best = Math.min(best, calc(n, costs, index + step, dp) + cost(costs, index, index + step));
                }
            }

            // cache and return the result
            return dp[index] = best;
        }

        private int cost(int[] costs, int i, int j) {
            return costs[j - 1] + (j - i) * (j - i);
        }
    }
}
