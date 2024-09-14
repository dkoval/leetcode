package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/">Longest Subarray With Maximum Bitwise AND</a>
 * <p>
 * You are given an integer array nums of size n.
 * <p>
 * Consider a non-empty subarray from nums that has the maximum possible bitwise AND.
 * <p>
 * In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with
 * a bitwise AND equal to k should be considered.
 * <p>
 * Return the length of the longest such subarray.
 * <p>
 * The bitwise AND of an array is the bitwise AND of all the numbers in it.
 * <p>
 * A subarray is a contiguous sequence of elements within an array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>1 <= nums[i] <= 10^6</li>
 * </ul>
 */
public interface LongestSubarrayWithMaximumBitwiseAND {

    int longestSubarray(int[] nums);

    // O(N) time | O(1) space
    class LongestSubarrayWithMaximumBitwiseANDRev1 implements LongestSubarrayWithMaximumBitwiseAND {

        @Override
        public int longestSubarray(int[] nums) {
            int n = nums.length;

            // Fact: x & y < max(x, y)
            // 1 <= nums[i] <= 10^6
            int maxNum = 0;
            int maxLength = 0;
            int i = 0;
            while (i < n) {
                if (nums[i] >= maxNum) {
                    // collect consecutive duplicates of nums[i]
                    int start = i;
                    while (i + 1 < n && nums[i + 1] == nums[i]) {
                        i++;
                    }

                    int length = i - start + 1;
                    if (nums[i] == maxNum) {
                        maxLength = Math.max(maxLength, length);
                    } else {
                        maxLength = length;
                        maxNum = nums[i];
                    }
                }
                i++;
            }
            return maxLength;
        }
    }
}
