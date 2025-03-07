package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/closest-prime-numbers-in-range/">Closest Prime Numbers in Range</a>
 * <p>
 * Given two positive integers left and right, find the two integers num1 and num2 such that:
 * <ul>
 *  <li>left <= num1 < num2 <= right .</li>
 *  <li>Both num1 and num2 are prime numbers.</li>
 *  <li>num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.</li>
 * </ul>
 * Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions,
 * return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
 */
public interface ClosestPrimeNumbersInRange {

    int[] closestPrimes(int left, int right);

    class ClosestPrimeNumbersInRangeRev1 implements ClosestPrimeNumbersInRange {

        @Override
        public int[] closestPrimes(int left, int right) {
            // Sieve of Eratosthenes
            final var primes = new boolean[right + 1];
            for (var i = 2; i <= right; i++) {
                primes[i] = true;
            }

            for (var i = 2; i * i <= right; i++) {
                if (!primes[i]) {
                    continue;
                }
                // discard all multiples of i
                for (var x = i * i; x <= right; x += i) {
                    primes[x] = false;
                }
            }

            final var ans = new int[]{-1, -1};
            var prev = -1;
            var bestDiff = Integer.MAX_VALUE;
            for (var curr = left; curr <= right; curr++) {
                if (!primes[curr]) {
                    continue;
                }

                if (prev != -1) {
                    final var currDiff = curr - prev;
                    if (currDiff < bestDiff) {
                        bestDiff = currDiff;
                        ans[0] = prev;
                        ans[1] = curr;
                    }
                }
                prev = curr;
            }
            return ans;
        }
    }
}
