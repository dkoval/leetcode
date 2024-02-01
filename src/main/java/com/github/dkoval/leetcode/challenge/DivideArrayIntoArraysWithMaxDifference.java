package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/">Divide Array Into Arrays With Max Difference</a>
 * <p>
 * You are given an integer array nums of size n and a positive integer k.
 * <p>
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 * <ul>
 *  <li>Each element of nums should be in exactly one array.</li>
 *  <li>The difference between any two elements in one array is less than or equal to k.</li>
 * </ul>
 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == nums.length</li>
 *  <li>1 <= n <= 10^5</li>
 *  <li>n is a multiple of 3</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 *  <li>1 <= k <= 10^5</li>
 * </ul>
 */
public interface DivideArrayIntoArraysWithMaxDifference {

    int[][] divideArray(int[] nums, int k);

    class DivideArrayIntoArraysWithMaxDifferenceRev1 implements DivideArrayIntoArraysWithMaxDifference {

        @Override
        public int[][] divideArray(int[] nums, int k) {
            // n is a multiple of 3
            int n = nums.length;

            Arrays.sort(nums);

            int numGroups = n / 3;
            int[][] ans = new int[numGroups][3];
            for (int g = 0; g < numGroups; g++) {
                ans[g][0] = nums[g * 3];
                for (int i = g * 3 + 1; i < (g + 1) * 3; i++) {
                    for (int j = g * 3; j < i; j++) {
                        if (nums[i] - nums[j] > k) {
                            return new int[0][0];
                        }
                    }
                    ans[g][i - g * 3] = nums[i];
                }
            }
            return ans;
        }
    }

    class DivideArrayIntoArraysWithMaxDifferenceRev2 implements DivideArrayIntoArraysWithMaxDifference {

        @Override
        public int[][] divideArray(int[] nums, int k) {
            // n is a multiple of 3
            int n = nums.length;

            Arrays.sort(nums);

            // Greedy
            int chunk = 0;
            int[][] ans = new int[n / 3][3];
            for (int i = 0; i < n; i += 3) {
                if (nums[i + 2] - nums[i] > k) {
                    return new int[0][0];
                }
                ans[chunk++] = Arrays.copyOfRange(nums, i, i + 3);
            }
            return ans;
        }
    }
}
