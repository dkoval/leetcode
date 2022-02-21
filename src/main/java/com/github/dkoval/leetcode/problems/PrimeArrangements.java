package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/prime-arrangements/">Prime Arrangements</a>
 * <p>
 * Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed).
 * <p>
 * (Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)
 * <p>
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 100
 */
public class PrimeArrangements {

    private static final int MOD = 1_000_000_007;

    public int numPrimeArrangements(int n) {
        // Sieve of Eratosthenes
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) continue;
            // exclude all multiples of i
            for (int x = i * i; x <= n; x += i) {
                primes[x] = false;
            }
        }

        int countPrimes = 0;
        for (boolean prime : primes) {
            if (prime) {
                countPrimes++;
            }
        }

        return (int) ((factorial(countPrimes) * factorial(n - countPrimes)) % MOD);
    }

    private long factorial(int n) {
        long prod = 1;
        for (int x = 2; x <= n; x++) {
            prod *= x;
            prod %= MOD;
        }
        return prod;
    }
}
