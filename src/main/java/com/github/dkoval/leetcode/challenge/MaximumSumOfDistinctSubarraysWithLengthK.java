package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/">Maximum Sum of Distinct Subarrays With Length K</a>
 * <p>
 * You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums
 * that meet the following conditions:
 * <p>
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions,
 * return 0.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= k <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface MaximumSumOfDistinctSubarraysWithLengthK {

    long maximumSubarraySum(int[] nums, int k);

    class MaximumSumOfDistinctSubarraysWithLengthKRev1 implements MaximumSumOfDistinctSubarraysWithLengthK {

        @Override
        public long maximumSubarraySum(int[] nums, int k) {
            int n = nums.length;

            // idea: sliding window
            // x -> number of occurrences of x in a sliding window
            Map<Integer, Integer> freq = new HashMap<>();
            long best = 0;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

                if (i >= k) {
                    // remove the first element of the previous window
                    sum -= nums[i - k];
                    int count = freq.get(nums[i - k]);
                    if (count > 1) {
                        freq.put(nums[i - k], count - 1);
                    } else {
                        freq.remove(nums[i - k]);
                    }
                }

                // maximize the sum of a valid sliding window
                if (i >= k - 1 && freq.size() == k) {
                    best = Math.max(best, sum);
                }
            }
            return best;
        }
    }
}
