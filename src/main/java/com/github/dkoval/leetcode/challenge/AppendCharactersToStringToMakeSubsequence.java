package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/">Append Characters to String to Make Subsequence</a>
 * <p>
 * You are given two strings s and t consisting of only lowercase English letters.
 * <p>
 * Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
 * <p>
 * A subsequence is a string that can be derived from another string by deleting some or no characters without changing
 * the order of the remaining characters.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length, t.length <= 10^5</li>
 *  <li>s and t consist only of lowercase English letters</li>
 * </ul>
 */
public interface AppendCharactersToStringToMakeSubsequence {

    int appendCharacters(String s, String t);

    // O(min(S, T)) time | O(1) space
    class AppendCharactersToStringToMakeSubsequenceRev1 implements AppendCharactersToStringToMakeSubsequence {

        @Override
        public int appendCharacters(String s, String t) {
            int m = s.length();
            int n = t.length();

            // find the longest prefix of t that is a subsequence of s
            int i = 0;
            int j = 0;
            while (i < m && j < n) {
                if (s.charAt(i) == t.charAt(j)) {
                    j++;
                }
                i++;
            }
            return n - j;
        }
    }
}
