package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/">Longest Common Subsequence</a>
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted
 * without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequence {

    // Time complexity: O(M*N)
    // Space complexity: O(M*N)
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] - denotes solution to lcs(text1[0:i], text2[0:j]) sub-problem
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                dp[i][j] = (c1 == c2)
                        // remove last character from text1 and text2
                        ? 1 + dp[i - 1][j - 1]
                        // either remove last character from text1 and leave text2 unmodified, or
                        // remove last character from text2 and leave text1 unmodified
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
