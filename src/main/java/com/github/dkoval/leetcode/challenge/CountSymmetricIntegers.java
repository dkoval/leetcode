package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-symmetric-integers/">Count Symmetric Integers</a>
 * <p>
 * You are given two positive integers low and high.
 * <p>
 * An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x.
 * Numbers with an odd number of digits are never symmetric.
 * <p>
 * Return the number of symmetric integers in the range [low, high].
 * <p>
 * Constraints:
 * <p>
 * 1 <= low <= high <= 10^4
 */
public interface CountSymmetricIntegers {

    int countSymmetricIntegers(int low, int high);

    class CountSymmetricIntegersRev1 implements CountSymmetricIntegers {

        private static boolean isSymmetric(int x) {
            final var s = Integer.toString(x);
            final var n = s.length();

            if (n % 2 != 0) {
                return false;
            }

            var balance = 0;
            for (var i = 0; i < n / 2; i++) {
                balance += s.charAt(i);
                balance -= s.charAt(n - i - 1);
            }
            return balance == 0;
        }

        @Override
        public int countSymmetricIntegers(int low, int high) {
            var count = 0;
            for (var x = low; x <= high; x++) {
                if (isSymmetric(x)) {
                    count++;
                }
            }
            return count;
        }
    }
}
