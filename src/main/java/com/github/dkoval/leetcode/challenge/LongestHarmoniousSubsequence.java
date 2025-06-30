package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/longest-harmonious-subsequence/">Longest Harmonious Subsequence</a>
 * <p>
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <ul>
 *  <ul>1 <= nums.length <= 2 * 10^4</li>
 *  <ul>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
 */
public interface LongestHarmoniousSubsequence {

    int findLHS(int[] nums);

    class LongestHarmoniousSubsequenceRev1 implements LongestHarmoniousSubsequence {

        // O(N) time | O(N) space
        @Override
        public int findLHS(int[] nums) {
            // Since the problem asks for the longest harmonious subsequence among all its possible subsequences,
            // the order of elements doesn't matter at all. Because of that, we can derive the answer by
            // maximizing count[n] + count[n + 1] sum. Note that n + 1 must exist in the array.
            final var count = new HashMap<Integer, Integer>();
            for (var n : nums) {
                count.put(n, count.getOrDefault(n, 0) + 1);
            }

            var best = 0;
            for (var n : count.keySet()) {
                if (count.containsKey(n + 1)) {
                    best = Math.max(best, count.get(n) + count.get(n + 1));
                }
            }
            return best;
        }
    }
}
