package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/">Check If Array Pairs Are Divisible by k</a>
 * <p>
 * Given an array of integers arr of even length n and an integer k.
 * <p>
 * We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
 * <p>
 * Return true If you can find a way to do that or false otherwise.
 * <p>
 * Constraints:
 * <ul>
 *  <li>arr.length == n</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>n is even</li>
 *  <li>-10^9 <= arr[i] <= 10^9</li>
 *  <li>1 <= k <= 10^5</li>
 * </ul>
 */
public interface CheckIfArrayPairsAreDivisibleByK {

    boolean canArrange(int[] arr, int k);

    class CheckIfArrayPairsAreDivisibleByKRev1 implements CheckIfArrayPairsAreDivisibleByK {

        @Override
        public boolean canArrange(int[] arr, int k) {
            int[] counts = new int[k];
            for (int x : arr) {
                // only last digit of a number in base k matters
                if (x < 0) {
                    // handle -x % k
                    x = k - (-x % k);
                }
                counts[x % k]++;
            }

            for (int x = 0; x <= k / 2; x++) {
                // x + y = k
                // (x + y) % k = 0
                //
                // NB. Appended % k handles scenario when
                // x = 0, y = k <=> x = 0, y = 0
                int y = (k - x) % k;

                if (x == y) {
                    if (counts[x] % 2 != 0) {
                        return false;
                    }
                } else {
                    if (counts[x] != counts[y]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
