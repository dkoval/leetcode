package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/">Convert Integer to the Sum of Two No-Zero Integers</a>
 * <p>
 * No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.
 * <p>
 * Given an integer n, return a list of two integers [a, b] where:
 * <p>
 * a and b are No-Zero integers.
 * <p>
 * a + b = n
 * The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 10^4
 */
public interface ConvertIntegerToSumOfTwoNoZeroIntegers {

    int[] getNoZeroIntegers(int n);

    class ConvertIntegerToSumOfTwoNoZeroIntegersRev1 implements ConvertIntegerToSumOfTwoNoZeroIntegers {

        @Override
        public int[] getNoZeroIntegers(int n) {
            for (var x = 1; x < n; x++) {
                if (isBad(x) || isBad(n - x)) {
                    continue;
                }
                return new int[]{x, n - x};
            }
            return new int[0];
        }

        private boolean isBad(int x) {
            while (x != 0) {
                if (x % 10 == 0) {
                    return true;
                }
                x /= 10;
            }
            return false;
        }
    }
}
