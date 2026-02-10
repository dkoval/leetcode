package com.github.dkoval.leetcode.challenge;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/longest-balanced-subarray-i/">Longest Balanced Subarray I</a>
 * <p>
 * You are given an integer array nums.
 * <p>
 * A subarray is called balanced if the number of distinct even numbers in the subarray is equal to the number of distinct odd numbers.
 * <p>
 * Return the length of the longest balanced subarray.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= nums.length <= 1500</li>
 *  <li>1 <= nums[i] <= 10^5</li>
 * </ul>
 */
public interface LongestBalancedSubarray1 {

    int longestBalanced(int[] nums);

    class LongestBalancedSubarray1Rev1 implements LongestBalancedSubarray1 {

        @Override
        public int longestBalanced(int[] nums) {
            final var n = nums.length;

            // brute force: try every subarray
            var best = 0;
            for (var left = 0; left < n; left++) {
                final var even = new HashSet<Integer>();
                final var odds = new HashSet<Integer>();
                for (var right = left; right < n; right++) {
                    final var xs = (nums[right] % 2 == 0) ? even : odds;
                    xs.add(nums[right]);

                    if (even.size() == odds.size()) {
                        best = Math.max(best, right - left + 1);
                    }
                }
            }
            return best;
        }
    }
}
