package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/">Maximum Element After Decreasing and Rearranging</a>
 * <p>
 * You are given an array of positive integers arr. Perform some operations (possibly none) on arr so that it satisfies these conditions:
 * <ul>
 *  <li>The value of the first element in arr must be 1.</li>
 *  <li>The absolute difference between any 2 adjacent elements must be less than or equal to 1. In other words,
 *  abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed). abs(x) is the absolute value of x.
 *  </li>
 * </ul>
 * There are 2 types of operations that you can perform any number of times:
 * <ul>
 *  <li>Decrease the value of any element of arr to a smaller positive integer.</li>
 *  <li>Rearrange the elements of arr to be in any order.</li>
 * </ul>
 * Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.
 */
public interface MaximumElementAfterDecreasingAndRearranging {

    int maximumElementAfterDecrementingAndRearranging(int[] arr);

    class MaximumElementAfterDecreasingAndRearrangingRev1 implements MaximumElementAfterDecreasingAndRearranging {

        @Override
        public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
            // 1 <= n <= 10^5
            int n = arr.length;

            Arrays.sort(arr);
            int best = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] - best <= 1) {
                    best = arr[i];
                } else {
                    best++;
                }
            }
            return best;
        }
    }
}
