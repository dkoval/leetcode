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
 *  <li>1 <= nums.length <= 100</li>
 *  <li>0 <= nums[i] <= 10^9</li>
 *  <li>0 <= k <= 10^9</li>
 * </ul>
 */
public interface SmallestStableIndex1 {

    int firstStableIndex(int[] nums, int k);

    class SmallestStableIndex1Rev1 implements SmallestStableIndex1 {

        @Override
        public int firstStableIndex(int[] nums, int k) {
            final var n = nums.length;

            final var max = new int[n];
            final var min = new int[n];
            max[0] = nums[0];
            min[n - 1] = nums[n - 1];
            for (var i = 1; i < n; i++) {
                max[i] = Math.max(nums[i], max[i - 1]);
                min[n - i - 1] = Math.min(nums[n - 1 - i], min[n - i]);
            }

            for (var i = 0; i < n; i++) {
                if (max[i] - min[i] <= k) {
                    return i;
                }
            }
            return -1;
        }
    }

    class SmallestStableIndex1Rev2 implements SmallestStableIndex1 {

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
