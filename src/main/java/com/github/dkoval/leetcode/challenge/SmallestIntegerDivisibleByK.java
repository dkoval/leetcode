package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/smallest-integer-divisible-by-k/">Smallest Integer Divisible by K</a>
 * <p>
 * Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k,
 * and n only contains the digit 1.
 * <p>
 * Return the length of n. If there is no such n, return -1.
 * <p>
 * Note: n may not fit in a 64-bit signed integer.
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= 10^5
 */
public interface SmallestIntegerDivisibleByK {

    int smallestRepunitDivByK(int k);

    // O(K) time | O(K) space
    class SmallestIntegerDivisibleByKCheckingLoop implements SmallestIntegerDivisibleByK {

        @Override
        public int smallestRepunitDivByK(int k) {
            int rem = 1 % k;
            int length = 1;

            // Properties of modular arithmetic:
            // (a + b) % c = (a % c + b % c) % c
            // (a * b) % c = (a % c * b % c) % c

            // Given N1 = 11...1, rem1 = N1 % k, where k >= 1, let's compute next N2 and rem2 values:
            // N2 = N1 * 10 + 1 (add digit 1 to the right of N1)
            // rem2 = N2 % k = (N1 * 10 + 1) % k = ((N1 * 10) % k + 1 % k) % k = ((N1 % k * 10 % k) % k + 1 % k) % k =
            // = (N1 % k * 10 % k + 1) % k = (rem1 * 10 % k + 1) % k

            // seen[] stores all possible remainders of N % k, i.e. {0, 1, ..., k - 1}.
            // The array is used to avoid running into infinite loop if N = 11...1 such that N % k = 0 doesn't exist.
            boolean[] seen = new boolean[k];
            while (rem != 0) {
                rem = (rem * 10 % k + 1) % k;
                length++;
                if (seen[rem]) {
                    return -1;
                }
                seen[rem] = true;
            }
            return length;
        }
    }

    // O(K) time | O(1) space
    class SmallestIntegerDivisibleByKPigeonholePrinciple implements SmallestIntegerDivisibleByK {

        @Override
        public int smallestRepunitDivByK(int k) {
            // Observation. In the previous solution seen[] stores k possible remainders of N % k, which means that
            // if N = 11...1 such that N % k = 0 exists, the while-loop executes <= k times.
            int rem = 0;
            for (int i = 1; i <= k; i++) {
                rem = (rem * 10 % k + 1) % k;
                if (rem == 0) {
                    return i;
                }
            }
            return -1;
        }
    }
}
