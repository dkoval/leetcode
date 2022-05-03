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
public interface ShortestUnsortedContinuousSubarray {

    int findUnsortedSubarray(int[] nums);

    // O(NlogN) time | O(N) space
    class ShortestUnsortedContinuousSubarrayNaive implements ShortestUnsortedContinuousSubarray {

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

    // O(N) time | O(1) space
    class ShortestUnsortedContinuousSubarrayInLinerTimeAndConstantSpace implements ShortestUnsortedContinuousSubarray {

        @Override
        public int findUnsortedSubarray(int[] nums) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // when going from left to right, find the lowest decreasing value
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    min = Math.min(min, nums[i]);
                    break;
                }
            }

            // when going from right to left, find the biggest increasing value
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] > nums[i + 1]) {
                    max = Math.max(max, nums[i]);
                    break;
                }
            }

            // nums[] is already sorted
            if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
                return 0;
            }

            // start index of the subarray is the 1st value from left to right that is > min
            int start = 0;
            for (; start < nums.length; start++) {
                if (nums[start] > min) {
                    break;
                }
            }

            // end index of the subarray is the 1st value from right to left that is < max
            int end = nums.length - 1;
            for (; end >= 0; end--) {
                if (nums[end] < max) {
                    break;
                }
            }

            return end - start + 1;
        }
    }
}
