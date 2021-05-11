package com.github.dkoval.leetcode.challenge;

import java.util.BitSet;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3738/">Count Primes</a>
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Constraints: 0 <= n <= 5 * 10^6
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        // Sieve of Eratosthenes
        BitSet primes = new BitSet(n);
        for (int i = 2; i < n; i++) {
            primes.set(i, true);
        }

        for (int x = 2; x * x < n; x++) {
            if (primes.get(x)) {
                int i = x * x;
                while (i < n) {
                    primes.set(i, false);
                    i += x;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (primes.get(i)) {
                count++;
            }
        }
        return count;
    }
}
