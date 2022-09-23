package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/">Concatenation of Consecutive Binary Numbers</a>
 * <p>
 * Given an integer n, return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 109 + 7.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 */
public interface ConcatenationOfConsecutiveBinaryNumbers {

    int concatenatedBinary(int n);

    class ConcatenationOfConsecutiveBinaryNumbersRev1 implements ConcatenationOfConsecutiveBinaryNumbers {

        private static final int MOD = 1_000_000_007;

        @Override
        public int concatenatedBinary(int n) {
            long ans = 0;
            for (int i = 1; i <= n; i++) {
                int x = i;
                int numBits = 0;
                while (x > 0) {
                    numBits++;
                    x >>= 1;
                }
                ans *= 1 << numBits;
                ans += i;
                ans %= MOD;
            }
            return (int) ans;

        }
    }
}
