package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/number-of-zero-filled-subarrays/">Number of Zero-Filled Subarrays</a>
 * <p>
 * Given an integer array nums, return the number of subarrays filled with 0.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface NumberOfZeroFilledSubarrays {

    long zeroFilledSubarray(int[] nums);

    // O(N) time | O(1) space
    class NumberOfZeroFilledSubarraysRev1 implements NumberOfZeroFilledSubarrays {

        @Override
        public long zeroFilledSubarray(int[] nums) {
            int n = nums.length;

            long total = 0L;
            int i = 0;
            while (i < n) {
                if (nums[i] != 0) {
                    i++;
                    continue;
                }

                int count = 0;
                while (i < n && nums[i] == 0) {
                    count++;
                    total += count;
                    i++;
                }
            }
            return total;
        }
    }
}
