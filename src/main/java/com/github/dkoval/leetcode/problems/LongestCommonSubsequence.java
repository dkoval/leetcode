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
public interface LongestCommonSubsequence {

    int longestCommonSubsequence(String text1, String text2);

    // O(M*N) time | O(M*N) space
    class LongestCommonSubsequenceDPTopDown implements LongestCommonSubsequence {

        @Override
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length();
            int n2 = text2.length();
            return longestCommonSubsequence(text1, n1 - 1, text2, n2 - 1, new Integer[n1][n2]);
        }

        // returns solution to the longest common subsequence problem for text1[0:i] and text2[0:j] prefixes
        private int longestCommonSubsequence(String text1, int i, String text2, int j, Integer[][] memo) {
            if (i < 0 || j < 0) {
                return 0;
            }

            if (memo[i][j] != null) {
                return memo[i][j];
            }

            if (text1.charAt(i) == text2.charAt(j)) {
                // remove i-th and j-th characters from text1 and text2 respectively
                memo[i][j] = 1 + longestCommonSubsequence(text1, i - 1, text2, j - 1, memo);
            } else {
                // either remove i-th character from text1 and leave text2 unmodified, or
                // remove j-th character from text2 and leave text1 unmodified
                memo[i][j] = Math.max(
                        longestCommonSubsequence(text1, i - 1, text2, j, memo),
                        longestCommonSubsequence(text1, i, text2, j - 1, memo));
            }
            return memo[i][j];
        }
    }

    // O(M*N) time | O(M*N) space
    class LongestCommonSubsequenceDPBottomUp implements LongestCommonSubsequence {

        @Override
        public int longestCommonSubsequence(String text1, String text2) {
            // dp[i][j] - denotes solution to lcs(text1[0:i], text2[0:j]) sub-problem
            int n1 = text1.length();
            int n2 = text2.length();
            int[][] dp = new int[n1 + 1][n2 + 1];

            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    char c1 = text1.charAt(i - 1);
                    char c2 = text2.charAt(j - 1);
                    dp[i][j] = (c1 == c2)
                            // remove last characters from text1[0:i] and text2[0:j] respectively
                            ? 1 + dp[i - 1][j - 1]
                            // either remove last character from text1[0:i] and leave text2[0:j] unmodified, or
                            // remove last character from text2[0:j] and leave text1[0:i] unmodified
                            : Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
            return dp[n1][n2];
        }
    }
}
