package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3567/">Squares of a Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
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
            int l = 0;
            int r = n - 1;
            int i = n - 1;
            while (l <= r) {
                int x = Math.abs(nums[l]);
                int y = Math.abs(nums[r]);
                if (x < y) {
                    ans[i] = y * y;
                    r--;
                } else {
                    ans[i] = x * x;
                    l++;
                }
                i--;
            }
            return ans;
        }
    }
}
