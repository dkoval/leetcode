package com.github.dkoval.leetcode.challenge;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/">Longest Arithmetic Subsequence of Given Difference</a>
 * <p>
 * Given an integer array arr and an integer difference, return the length of the longest subsequence in arr
 * which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.
 * <p>
 * A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= arr.length <= 10^5</li>
 *  <li>-10^4 <= arr[i], difference <= 10^4</li>
 * </ul>
 */
public interface LongestArithmeticSubsequenceOfGivenDifference {

    int longestSubsequence(int[] arr, int difference);

    // O(N) time | O(N) space
    class LongestArithmeticSubsequenceOfGivenDifferenceRev1 implements LongestArithmeticSubsequenceOfGivenDifference {

        @Override
        public int longestSubsequence(int[] arr, int difference) {
            int n = arr.length;

            // seen[x] - the length of the longest arithmetic subsequence ending at x
            Map<Integer, Integer> seen = new HashMap<>();
            int best = 1;
            for (int curr : arr) {
                int prev = curr - difference;
                int len = seen.getOrDefault(prev, 0) + 1;
                best = Math.max(best, len);
                seen.put(curr, len);
            }
            return best;
        }
    }
}
