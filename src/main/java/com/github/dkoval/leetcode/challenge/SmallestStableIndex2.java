package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/smallest-stable-index-i/">Smallest Stable Index I</a>
 * <p>
 * You are given an integer array nums of length n and an integer k.
 * <p>
 * For each index i, define its instability score as max(nums[0..i]) - min(nums[i..n - 1]).
 * <p>
 * In other words:
 * <p>
 * max(nums[0..i]) is the largest value among the elements from index 0 to index i.
 * min(nums[i..n - 1]) is the smallest value among the elements from index i to index n - 1.
 * An index i is called stable if its instability score is less than or equal to k.
 * <p>
 * Return the smallest stable index. If no such index exists, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 10^9</li>
 *  <li>0 <= nums[i] <= 10^9</li>
 *  <li>0 <= k <= 10^9</li>
 * </ul>
 */
public interface SmallestStableIndex2 {

    int firstStableIndex(int[] nums, int k);

    class SmallestStableIndex2Rev1 implements SmallestStableIndex2 {

        @Override
        public int firstStableIndex(int[] nums, int k) {
            final var n = nums.length;

            final var min = new int[n];
            min[n - 1] = nums[n - 1];
            for (var i = n - 2; i >= 0; i--) {
                min[i] = Math.min(nums[i], min[i + 1]);
            }

            var max = Integer.MIN_VALUE;
            for (var i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
                if (max - min[i] <= k) {
                    return i;
                }
            }
            return -1;
        }
    }
}
