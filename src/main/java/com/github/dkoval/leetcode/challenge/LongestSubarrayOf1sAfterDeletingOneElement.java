package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">Longest Subarray of 1's After Deleting One Element</a>
 * <p>
 * Given a binary array nums, you should delete one element from it.
 * <p>
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^5</li>
 *  <li>nums[i] is either 0 or 1</li>
 * </ul>
 */
public interface LongestSubarrayOf1sAfterDeletingOneElement {

    int longestSubarray(int[] nums);

    // O(N) time | O(1) space
    class LongestSubarrayOf1sAfterDeletingOneElementRev1 implements LongestSubarrayOf1sAfterDeletingOneElement {

        @Override
        public int longestSubarray(int[] nums) {
            int n = nums.length;

            // Idea: sliding window containing at most one 0
            int start = 0;
            int end = 0;

            int best = 0;
            int lastZero = -1;
            while (end < n) {
                if (nums[end] == 0) {
                    if (lastZero >= 0) {
                        start = lastZero + 1;
                    }
                    lastZero = end;
                }
                best = Math.max(best, end - start + 1);
                end++;
            }
            return Math.max(best - 1, 0);
        }
    }

    // O(N) time | O(1) space
    class LongestSubarrayOf1sAfterDeletingOneElementRev2 implements LongestSubarrayOf1sAfterDeletingOneElement {

        @Override
        public int longestSubarray(int[] nums) {
            final var n = nums.length;

            // idea: sliding window
            var best = 0;
            var zeros = 0;
            var left = 0;
            for (var right = 0; right < n; right++) {
                if (nums[right] == 0) {
                    zeros++;
                }

                // shrink the window
                while (zeros > 1) {
                    if (nums[left] == 0) {
                        zeros--;
                    }
                    left++;
                }

                best = Math.max(best, right - left);
            }
            return best;
        }
    }
}
