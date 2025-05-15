package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/">Longest Unequal Adjacent Groups Subsequence I</a>
 * <p>
 * You are given a string array words and a binary array groups both of length n.
 * <p>
 * A subsequence of words is alternating if for any two consecutive strings in the sequence, their corresponding elements
 * at the same indices in groups are different (that is, there cannot be consecutive 0 or 1).
 * <p>
 * Your task is to select the longest alternating subsequence from words.
 * <p>
 * Return the selected subsequence. If there are multiple answers, return any of them.
 * <p>
 * Note: The elements in words are distinct.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == words.length == groups.length <= 100</li>
 *  <li>1 <= words[i].length <= 10</li>
 *  <li>groups[i] is either 0 or 1.</li>
 *  <li>words consists of distinct strings.</li>
 *  <li>words[i] consists of lowercase English letters.</li>
 * </ul>
 */
public interface LongestUnequalAdjacentGroupsSubsequence1 {

    List<String> getLongestSubsequence(String[] words, int[] groups);

    class LongestUnequalAdjacentGroupsSubsequence1Rev1 implements LongestUnequalAdjacentGroupsSubsequence1 {

        @Override
        public List<String> getLongestSubsequence(String[] words, int[] groups) {
            final var n = words.length;

            final var ans = new ArrayList<String>();
            ans.add(words[0]);

            for (var i = 1; i < n; i++) {
                if (groups[i] != groups[i - 1]) {
                    ans.add(words[i]);
                }
            }
            return ans;
        }
    }
}
