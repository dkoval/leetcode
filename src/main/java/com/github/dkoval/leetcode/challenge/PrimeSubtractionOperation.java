package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/prime-subtraction-operation/">Prime Subtraction Operation</a>
 * <p>
 * You are given a 0-indexed integer array nums of length n.
 * <p>
 * You can perform the following operation as many times as you want:
 * <p>
 * Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
 * <p>
 * Return true if you can make nums a strictly increasing array using the above operation and false otherwise.
 * <p>
 * A strictly increasing array is an array whose each element is strictly greater than its preceding element.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 1000</li>
 *  <li>nums.length == n</li>
 * </ul>
 */
public interface PrimeSubtractionOperation {

    boolean primeSubOperation(int[] nums);

    class PrimeSubtractionOperationRev1 implements PrimeSubtractionOperation {
        // PRIMES[x] == true if x is a prime number.
        // Constraints: 1 <= x <= 1000
        private static final boolean[] PRIMES = primes(1001);

        private static boolean[] primes(int n) {
            // sieve of Eratosthenes
            boolean[] primes = new boolean[n + 1];
            Arrays.fill(primes, true);
            primes[0] = false;
            primes[1] = false;

            for (int i = 2; i <= n; i++) {
                if (primes[i]) {
                    // discard all multiples of i
                    int j = i * i;
                    while (j <= n) {
                        primes[j] = false;
                        j += i;
                    }
                }
            }
            return primes;
        }

        @Override
        public boolean primeSubOperation(int[] nums) {
            // Idea: to keep the array sorted in ASC order, minimize each nums[i]
            // by subtracting the largest possible prime number < nums[i] (greedy approach).

            // Brute force
            int prev = 0;
            for (int x : nums) {
                // Check if there's a prime number in [2 .. x - 1 - prev] range.
                // To minimize x, we want the largest possible prime number,
                // therefore the candidates are checked in the reversed order.
                int p = 0;
                for (int i = x - 1 - prev; i >= 2; i--) {
                    if (PRIMES[i]) {
                        p = i;
                        break;
                    }
                }

                if (x - p <= prev) {
                    return false;
                }
                prev = x - p;
            }
            return true;
        }
    }
}
