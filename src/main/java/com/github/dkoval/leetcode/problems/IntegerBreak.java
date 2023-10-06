package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/integer-break/">Integer Break</a>
 * <p>
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 * <p>
 * Return the maximum product you can get.
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 58
 */
public interface IntegerBreak {

    int integerBreak(int n);

    class IntegerBreakRev1 implements IntegerBreak {

        @Override
        public int integerBreak(int n) {
            // n = 2, 2 = 1 + 1, P = 1 * 1 = 1
            // n = 3, 3 = 1 + 2, P = 1 * 2 = 2
            // n = 4, 4 = 2 + 2, P = 2 * 2 = 4
            // n = 5, 5 = 2 + 3, P = 2 * 3 = 6
            // n = 6, 6 = 3 + 3, P = 3 * 3 = 9
            // ---
            // n = 7, 7 = 3 + 4, P = 3 * P(4) = 3 * 4 = 12
            // n = 8, 8 = 3 + 5, P = 3 * P(5) = 3 * 6 = 18
            // n = 9, 9 = 3 + 6, P = 3 * P(6) = 3 * 9 = 27
            // n = 10, 10 = 2 + 8, P = 2 * P(8) = 2 * 18 = 36
            // n = 11, 11 = 2 + 9, P = 2 * P(9) = 2 * 27 = 54
            // n = 12, 12 = 3 + 9, P = 3 * P(9) = 3 * 27 = 81

            // dp[i] - max product you can get by breaking i into sum of k positive integers, where k >= 2
            int[] dp = new int[n + 1];
            dp[2] = 1;

            // n < 7
            for (int i = 3; i <= n && i < 7; i++) {
                dp[i] = Math.max(2 * (i - 2), 3 * (i - 3));
            }

            // n >= 7
            for (int i = 7; i <= n; i++) {
                dp[i] = Math.max(2 * dp[i - 2], 3 * dp[i - 3]);
            }
            return dp[n];
        }
    }

    class IntegerBreakRev2 implements IntegerBreak {

        @Override
        public int integerBreak(int n) {
            // DP top-down
            int[] cache = new int[n + 1];
            return calculate(n, cache);
        }

        private int calculate(int n, int[] cache) {
            if (n == 2) {
                // 2 = 1 + 1,
                // 1 * 1 = 1
                return 1;
            }

            // already solved?
            if (cache[n] != 0) {
                return cache[n];
            }

            int best = 1;
            for (int x = 1; x <= n / 2; x++) {
                int y = n - x;

                // option #1: use x and y
                best = Math.max(best, x * y);

                int resX = calculate(x, cache);
                int resY = calculate(y, cache);

                // option #2: break x, leave y as is
                best = Math.max(best, resX * y);
                // option #3: leave x as is, break y
                best = Math.max(best, x * resY);
                // option #4: break both x and y
                best = Math.max(best, resX * resY);
            }

            // cache and return the answer
            return cache[n] = best;
        }
    }
}
