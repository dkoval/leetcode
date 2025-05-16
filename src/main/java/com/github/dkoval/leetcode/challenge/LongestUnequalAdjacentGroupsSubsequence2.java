package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/">Longest Unequal Adjacent Groups Subsequence II</a>
 * <p>
 * You are given a string array words, and an array groups, both arrays having length n.
 * <p>
 * The hamming distance between two strings of equal length is the number of positions at which the corresponding
 * characters are different.
 * <p>
 * You need to select the longest subsequence from an array of indices [0, 1, ..., n - 1], such that for the subsequence
 * denoted as [i0, i1, ..., ik-1] having length k, the following holds:
 * <ul>
 *  <li>For adjacent indices in the subsequence, their corresponding groups are unequal, i.e., groups[ij] != groups[ij+1], for each j where 0 < j + 1 < k.</li>
 *  <li>words[ij] and words[ij+1] are equal in length, and the hamming distance between them is 1, where 0 < j + 1 < k, for all indices in the subsequence.</li>
 * </ul>
 * Return a string array containing the words corresponding to the indices (in order) in the selected subsequence. If there are multiple answers, return any of them.
 * <p>
 * Note: strings in words may be unequal in length.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n == words.length == groups.length <= 1000</li>
 *  <li>1 <= words[i].length <= 10</li>
 *  <li>1 <= groups[i] <= n</li>
 *  <li>words consists of distinct strings.</li>
 *  <li>words[i] consists of lowercase English letters.</li>
 * </ul>
 */
public interface LongestUnequalAdjacentGroupsSubsequence2 {

    List<String> getWordsInLongestSubsequence(String[] words, int[] groups);

    // O(N^2) time | O(N) space
    class LongestUnequalAdjacentGroupsSubsequence2Rev1 implements LongestUnequalAdjacentGroupsSubsequence2 {

        @Override
        public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
            final var n = words.length;

            // dp[i] - the length of the longest subsequence ending with words[i] that satisfies the conditions
            final var dp = new int[n];
            dp[0] = 1;

            // the index of max(dp)
            var bestIndex = 0;

            // prev[i] is the index that led to i (implicit edge in a graph of words)
            final var prev = new int[n];
            Arrays.fill(prev, -1);

            for (var i = 1; i < n; i++) {
                dp[i] = 1;
                for (var j = 0; j < i; j++) {
                    if (groups[i] != groups[j] && words[i].length() == words[j].length() && okDistance(words[i], words[j])) {
                        if (dp[j] + 1 > dp[i]) {
                            dp[i] = dp[j] + 1;
                            prev[i] = j;
                        }
                    }
                }

                if (dp[i] > dp[bestIndex]) {
                    bestIndex = i;
                }
            }

            // reconstruct the path
            final var ans = new ArrayList<String>();
            var index = bestIndex;
            while (index != -1) {
                ans.add(words[index]);
                index = prev[index];
            }

            Collections.reverse(ans);
            return ans;
        }

        private boolean okDistance(String s1, String s2) {
            var mismatches = 0;
            for (var i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (++mismatches > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
