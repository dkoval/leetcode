package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/factorial-trailing-zeroes/">Factorial Trailing Zeroes</a>
 * <p>
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 10^4
 */
public interface FactorialTrailingZeroes {

    int trailingZeroes(int n);

    class FactorialTrailingZeroesUsingFactorization implements FactorialTrailingZeroes {

        @Override
        public int trailingZeroes(int n) {
            // Every 10 = 2 * 5 gives us a trailing zero.
            // Numbers of form x = 2^k * 5^m, where k >= 0 and m >= 0,
            // generate 10s
            int count2 = 0;
            int count5 = 0;
            for (int i = 1; i <= n; i++) {
                int x = i;
                while (x % 2 == 0 || x % 5 == 0) {
                    if (x % 2 == 0) {
                        count2++;
                        x /= 2;
                    } else {
                        count5++;
                        x /= 5;
                    }
                }
            }
            return Math.min(count2, count5);
        }
    }
}
