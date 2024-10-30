package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/">Minimum Number of Removals to Make Mountain Array (Hard)</a>
 * <p>
 * You may recall that an array arr is a mountain array if and only if:
 * <ul>
 *  <li>arr.length >= 3</li>
 *  <li>There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 *    <ul>
 *      <li>arr[0] < arr[1] < ... < arr[i - 1] < arr[i]</li>
 *      <li>arr[i] > arr[i + 1] > ... > arr[arr.length - 1]</li>
 *    </ul>
 *  </li>
 * </ul>
 * Given an integer array nums, return the minimum number of elements to remove to make nums a mountain array.
 * <p>
 * Constraints:
 * <ul>
 *  <li>3 <= nums.length <= 1000</li>
 *  <li>1 <= nums[i] <= 109</li>
 *  <li>It is guaranteed that you can make a mountain array out of nums.</li>
 * </ul>
 */
public interface MinimumNumberOfRemovalsToMakeMountainArray {

    int minimumMountainRemovals(int[] nums);

    class MinimumNumberOfRemovalsToMakeMountainArrayRev1 implements MinimumNumberOfRemovalsToMakeMountainArray {

        @Override
        public int minimumMountainRemovals(int[] nums) {
            // mountain array: [increasing sequence][peak][decreasing sequence]
            int n = nums.length;

            // left[i] - the length of the longest increasing sequence ending at nums[i]
            int[] left = new int[n];
            // right[i] - the length of the longest decreasing sequence starting at nums[i]
            int[] right = new int[n];

            for (int i = 0; i < n; i++) {
                left[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        left[i] = Math.max(left[i], 1 + left[j]);
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                right[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (nums[i] > nums[j]) {
                        right[i] = Math.max(right[i], 1 + right[j]);
                    }
                }
            }

            // the minimum number of elements to remove
            int best = n;
            for (int i = 0; i < n; i++) {
                if (left[i] > 1 && right[i] > 1) {
                    // number of elements to remove = n - the length of a mountain array with the peak at nums[i]
                    best = Math.min(best, n - left[i] - right[i] + 1);
                }
            }
            return best;
        }
    }
}
