package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/count-number-of-nice-subarrays/">Count Number of Nice Subarrays</a>
 * <p>
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 * <p>
 * Return the number of nice sub-arrays.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 50000</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 *  <li>1 <= k <= nums.length</li>
 * </ul>
 */
public interface CountNumberOfNiceSubarrays {

    int numberOfSubarrays(int[] nums, int k);

    // O(N) time | O(N) space
    class CountNumberOfNiceSubarraysRev1 implements CountNumberOfNiceSubarrays {

        @Override
        public int numberOfSubarrays(int[] nums, int k) {
            int n = nums.length;

            // Replace each even -> 0, odd -> 1
            // Use prefix sum to find the answer:
            // prefixSum[i] is the number of odd numbers in nums[0 : i]
            int[] prefixSum = new int[n];
            // prefix sum -> count
            Map<Integer, Integer> counts = new HashMap<>();
            counts.put(0, 1);
            for (int i = 0; i < n; i++) {
                prefixSum[i] += (i > 0) ? prefixSum[i - 1] : 0;
                prefixSum[i] += nums[i] % 2;
                counts.put(prefixSum[i], counts.getOrDefault(prefixSum[i], 0) + 1);
            }

            int total = 0;
            for (int x : prefixSum) {
                if (x < k) {
                    continue;
                }
                int prefix = x - k;
                total += counts.get(prefix);
            }
            return total;
        }
    }
}
