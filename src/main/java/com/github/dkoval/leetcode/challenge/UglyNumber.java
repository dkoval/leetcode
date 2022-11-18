package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/ugly-number/">Ugly Number </a>
 * <p>
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * <p>
 * Given an integer n, return true if n is an ugly number.
 * <p>
 * Constraints:
 * <ul>
 *  <li>-2^31 <= n <= 2^31 - 1</li>
 * </ul>
 */
public interface UglyNumber {

    boolean isUgly(int n);

    class UglyNumberRev1 implements UglyNumber {

        private static final int[] FACTORS = {2, 3, 5};

        @Override
        public boolean isUgly(int n) {
            if (n == 0) {
                return false;
            }

            for (int factor : FACTORS) {
                while (n % factor == 0) {
                    n /= factor;
                }
            }
            return n == 1;
        }
    }
}
