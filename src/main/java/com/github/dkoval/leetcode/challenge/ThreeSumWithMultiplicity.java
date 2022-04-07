package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/3sum-with-multiplicity/">3Sum With Multiplicity</a>
 * <p>
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that
 * i < j < k and arr[i] + arr[j] + arr[k] == target.
 * <p>
 * As the answer can be very large, return it modulo 10^9 + 7.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= arr.length <= 3000</li>
 *  <li>0 <= arr[i] <= 100</li>
 *  <li>0 <= target <= 300</li>
 * </ul>
 */
public class ThreeSumWithMultiplicity {

    private static final int MOD = 1_000_000_007;

    // Worst case: O(N^2) time | O(N) space
    public int threeSumMulti(int[] arr, int target) {
        // arr[i] + arr[j] + arr[k] = target
        // arr[k] = target - arr[i] - arr[j]
        Map<Integer, Long> counts = new HashMap<>();
        for (int x : arr) {
            counts.put(x, counts.getOrDefault(x, 0L) + 1);
        }

        long total = 0;
        Set<Integer> nums = counts.keySet();
        for (int x : nums) {
            for (int y : nums) {
                int z = target - x - y;
                if (!nums.contains(z)) {
                    continue;
                }

                if (x == y) {
                    long n = counts.get(x);
                    if (y == z) {
                        // x == y == z
                        // C(n, 3) = (n * (n - 1) * (n - 2)) / 3!
                        total += n * (n - 1) * (n - 2) / 6;
                    } else {
                        // x == y != z
                        // C(n, 2) = (n * (n - 1)) / 2!
                        total += n * (n - 1) / 2 * counts.get(z);
                    }
                } else if (x < y && y < z) {
                    // x < y < z check guarantees that (x, y, z) triplet will be processed exactly once
                    total += counts.get(x) * counts.get(y) * counts.get(z);
                }
            }
        }
        return (int)(total % MOD);
    }
}
