package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/571/week-3-december-15th-december-21st/3567/">Squares of a Sorted Array</a>
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */
public abstract class SquaresOfSortedArray {

    public abstract int[] sortedSquares(int[] nums);

    public static class SquaresOfSortedArrayUsingSorting extends SquaresOfSortedArray {

        @Override
        public int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] *= nums[i];
            }
            Arrays.sort(nums);
            return nums;
        }
    }
}
