package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/is-subsequence/">Is Subsequence</a>
 * <p>
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= s.length <= 100</li>
 *  <li>0 <= t.length <= 10^4</li>
 *  <li>s and t consist only of lowercase English letters</li>
 *  </ul>
 */
public interface IsSubsequence {

    boolean isSubsequence(String s, String t);

    class IsSubsequenceRev2 implements IsSubsequence {

        @Override
        public boolean isSubsequence(String s, String t) {
            if (s.isEmpty()) {
                return true;
            }

            if (t.isEmpty()) {
                return false;
            }

            int sIndex = 0;
            int tIndex = 0;
            while (sIndex < s.length() && tIndex < t.length()) {
                char c = s.charAt(sIndex);
                while (tIndex < t.length() && t.charAt(tIndex) != c) {
                    tIndex++;
                }
                sIndex++;
                tIndex++;
            }
            return sIndex == s.length() && tIndex <= t.length();
        }
    }
}
