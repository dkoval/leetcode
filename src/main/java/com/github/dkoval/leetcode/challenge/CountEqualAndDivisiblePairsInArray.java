package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-equal-and-divisible-pairs-in-array/">Count Equal and Divisible Pairs in an Array</a>
 * <p>
 * Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j)
 * where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 100</li>
 *  <li>1 <= nums[i], k <= 100</li>
 * </ul>
 */
public interface CountEqualAndDivisiblePairsInArray {

    int countPairs(int[] nums, int k);

    class CountEqualAndDivisiblePairsInArrayRev1 implements CountEqualAndDivisiblePairsInArray {

        @Override
        public int countPairs(int[] nums, int k) {
            final var n = nums.length;

            var count = 0;
            for (var i = 0; i < n - 1; i++) {
                for (var j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j] && (i * j) % k == 0) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
