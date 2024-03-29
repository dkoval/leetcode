package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/perfect-squares/">Perfect Squares</a>
 * <p>
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * <p>
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^4
 */
public interface PerfectSquares {

    int numSquares(int n);

    // O(N * sqrt(n)) time | O(N) space
    class PerfectSquaresDPTopDown implements PerfectSquares {

        @Override
        public int numSquares(int n) {
            // memo[i] denotes the least number of perfect square numbers that sum to i
            return solve(n, new Integer[n + 1]);
        }

        private int solve(int n, Integer[] dp) {
            // base case
            if (n == 0) {
                return 0;
            }

            // already solved?
            if (dp[n] != null) {
                return dp[n];
            }

            // upper boundary: n = 1^2 + 1^2 ... + 1^2 (n times)
            int best = n;
            // try all x such that x^2 <= n
            for (int x = 1; x * x <= n; x++) {
                best = Math.min(best, 1 + solve(n - x * x, dp));
            }

            // cache and return
            return dp[n] = best;
        }
    }

    // O(N * sqrt(n)) time | O(N) space
    // Resource: https://www.youtube.com/watch?v=HLZLwjzIVGo
    class PerfectSquaresDPBottomUp implements PerfectSquares {

        @Override
        public int numSquares(int n) {
            // dp[i] denotes the least number of perfect square numbers that sum to i
            int[] dp = new int[n + 1];

            // base case
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                // upper boundary: n = 1^2 + 1^2 ... + 1^2 (n times)
                dp[i] = i;
                for (int x = 1; x * x <= i; x++) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - x * x]);
                }
            }
            return dp[n];
        }
    }
}
