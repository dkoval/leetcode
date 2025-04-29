package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/">Count Subarrays Where Max Element Appears at Least K Times</a>
 * <p>
 * You are given an integer array nums and a positive integer k.
 * <p>
 * Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^6</li>
 *  <li>1 <= k <= 10^5</li>
 * </ul>
 */
public interface CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

    long countSubarrays(int[] nums, int k);

    // O(N) time | O(1) space
    class CountSubarraysWhereMaxElementAppearsAtLeastKTimesRev1 implements CountSubarraysWhereMaxElementAppearsAtLeastKTimes {

        @Override
        public long countSubarrays(int[] nums, int k) {
            final var n = nums.length;

            var max = Integer.MIN_VALUE;
            for (var x : nums) {
                max = Math.max(max, x);
            }

            // sliding window
            var count = 0;
            var left = 0;
            var total = 0L;
            for (int x : nums) {
                if (x == max) {
                    count++;
                }

                // shrink the window from the left to make it the smallest possible containing at least k max elements
                while (count >= k) {
                    if (nums[left] == max) {
                        count--;
                    }
                    left++;
                }
                // all subarrays starting at index in [0, left] range and ending at nums[right] are valid
                total += left;
            }
            return total;
        }
    }
}
