package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/">Squares of a Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^4</li>
 *  <li>-10^4 <= nums[i] <= 10^4</li>
 *  <li>nums is sorted in non-decreasing order</li>
 * </ul>
 */
public interface SquaresOfSortedArray {

    int[] sortedSquares(int[] nums);

    // O(N*logN) time | O(1) space
    class SquaresOfSortedArrayUsingSorting implements SquaresOfSortedArray {

        @Override
        public int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] *= nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }
    }

    // O(N) time | O(N) space
    class SquaresOfSortedArrayUsingTwoPointers implements SquaresOfSortedArray {

        @Override
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;

            int[] ans = new int[n];
            int i = n - 1;

            int left = 0;
            int right = n - 1;
            while (left <= right) {
                if (Math.abs(nums[left]) >= nums[right]) {
                    ans[i] = nums[left] * nums[left];
                    left++;
                } else {
                    ans[i] = nums[right] * nums[right];
                    right--;
                }
                i--;
            }
            return ans;
        }
    }
}
