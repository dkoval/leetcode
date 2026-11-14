package com.github.dkoval.leetcode.challenge;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-positive-sum-subarray/">Minimum Positive Sum Subarray </a>
 * <p>
 * You are given an integer array nums and two integers l and r. Your task is to find the minimum sum of a subarray
 * whose size is between l and r (inclusive) and whose sum is greater than 0.
 * <p>
 * Return the minimum sum of such a subarray. If no such subarray exists, return -1.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= l <= r <= nums.length</li>
 *  <li>-1000 <= nums[i] <= 1000</li>
 * </ul>
 */
public interface MinimumPositiveSumSubarray {

    int minimumSumSubarray(List<Integer> nums, int l, int r);

    class MinimumPositiveSumSubarrayRev1 implements MinimumPositiveSumSubarray {

        @Override
        public int minimumSumSubarray(List<Integer> nums, int l, int r) {
            final var n = nums.size();

            var best = Integer.MAX_VALUE;
            for (var length = l; length <= r; length++) {
                var sum = 0;
                var left = 0;
                for (var right = 0; right < n; right++) {
                    sum += nums.get(right);

                    final var subarrLength = right - left + 1;
                    if (subarrLength < length) {
                        continue;
                    }

                    if (subarrLength > length) {
                        sum -= nums.get(right - length);
                        left++;
                    }

                    if (sum > 0) {
                        best = Math.min(best, sum);
                    }
                }
            }
            return (best != Integer.MAX_VALUE) ? best : -1;
        }
    }
}
