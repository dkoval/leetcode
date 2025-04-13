package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-good-numbers/">Count Good Numbers</a>
 * <p>
 * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
 * <p>
 * For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime.
 * However, "3245" is not good because 3 is at an even index but is not even.
 * <p>
 * Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 10^9 + 7.
 * <p>
 * A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
 */
public interface CountGoodNumbers {

    int MOD = 1_000_000_007;

    int countGoodNumbers(long n);

    class CountGoodNumbersRev1 implements CountGoodNumbers {

        @Override
        public int countGoodNumbers(long n) {
            // n = 3, indices: 0, 1, 2
            //                   ^
            // n = 4, indices: 0, 1, 2, 3
            //                   ^     ^

            // number of odd indices
            final var odd = n / 2;
            // number of even indices
            final var even = n - odd;

            // digits to be put at even indices: 0, 2, 4, 6, 8
            // digits to be put at odd indices:  2, 3, 5, 7 (must be prime)
            return (int) ((pow(5, even) * pow(4, odd)) % MOD);
        }

        private long pow(long x, long n) {
            // https://en.wikipedia.org/wiki/Modular_exponentiation
            // x ^ n = x ^ (n / 2) * x ^ (n / 2), if n is even
            // x ^ n = x ^ (n / 2) * x ^ (n / 2) * x, if n is odd
            var ans = 1L;
            x %= MOD;
            while (n > 0) {
                if (n % 2 == 1) {
                    ans *= x;
                    ans %= MOD;
                }
                n /= 2;
                x *= x;
                x %= MOD;
            }
            return ans;
        }
    }
}
