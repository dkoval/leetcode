package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/587/week-4-february-22nd-february-28th/3652/">Shortest Unsorted Continuous Subarray</a>
 * <p>
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order.
 * <p>
 * Return the shortest such subarray and output its length.
 */
public abstract class ShortestUnsortedContinuousSubarray {

    public abstract int findUnsortedSubarray(int[] nums);

    // O(NlogN) time | O(N) space
    public static class ShortestUnsortedContinuousSubarrayNaive extends ShortestUnsortedContinuousSubarray {

        @Override
        public int findUnsortedSubarray(int[] nums) {
            int[] copy = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copy);

            int start = 0;
            for (; start < nums.length; start++) {
                if (copy[start] != nums[start]) {
                    break;
                }
            }

            if (start == nums.length) {
                return 0;
            }

            int end = nums.length - 1;
            for (; end >= 0; end--) {
                if (copy[end] != nums[end]) {
                    break;
                }
            }

            return end - start + 1;
        }
    }
}
