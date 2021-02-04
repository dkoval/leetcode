package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3628/">Longest Harmonious Subsequence</a>
 * <p>
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
 */
public class LongestHarmoniousSubsequence {

    // O(N) time | O(N) space
    public int findLHS(int[] nums) {
        // Since the problem asks for longest harmonious subsequence among all its possible subsequences,
        // the order of elements doesn't matter at all. Because of that, we can derive the answer by
        // maximizing count[n] + count[n + 1] sum. Note that n + 1 must exist in the array.
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        int longest = 0;
        for (int n : count.keySet()) {
            if (count.containsKey(n + 1)) {
                longest = Math.max(longest, count.get(n) + count.get(n + 1));
            }
        }
        return longest;
    }
}
