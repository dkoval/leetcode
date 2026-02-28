package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/">Concatenation of Consecutive Binary Numbers</a>
 * <p>
 * Given an integer n, return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 */
public interface ConcatenationOfConsecutiveBinaryNumbers {

    int MOD = 1_000_000_007;

    int concatenatedBinary(int n);

    class ConcatenationOfConsecutiveBinaryNumbersRev1 implements ConcatenationOfConsecutiveBinaryNumbers {

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
                ans *= 1L << numBits;
                ans += i;
                ans %= MOD;
            }
            return (int) ans;

        }
    }

    class ConcatenationOfConsecutiveBinaryNumbersRev2 implements ConcatenationOfConsecutiveBinaryNumbers {

        @Override
        public int concatenatedBinary(int n) {
            // 1 - has 1 bit
            // 2 - has 2 bits
            // 4 - has 3 bits
            // 8 - has 4 bits
            var res = 0L;
            var numBits = 0; // the number of bits required to represent x
            for (var x = 1; x <= n; x++) {
                if (isPow2(x)) {
                    numBits++;
                }

                // 1. left-shift the result by k bits, i.e. multiply it by 2 ^ k
                // 2. append x to the result
                res *= (1L << numBits);
                res += x;
                res %= MOD;
            }
            return (int) res;
        }

        private boolean isPow2(int x) {
            return (x & (x - 1)) == 0;
        }
    }
}
