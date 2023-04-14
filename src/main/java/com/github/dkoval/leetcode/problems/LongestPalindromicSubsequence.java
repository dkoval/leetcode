package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">Longest Palindromic Subsequence</a>
 * <p>
 * Given a string s, find the longest palindromic subsequence's length in s.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= s.length <= 1000</li>
 *  <li>s consists only of lowercase English letters.</li>
 * </ul>
 */
public interface LongestPalindromicSubsequence {

    int longestPalindromeSubseq(String s);

    // Resource: https://www.techiedelight.com/longest-palindromic-subsequence-using-dynamic-programming
    // O(N^2) time | O(N^2) space
    class LongestPalindromicSubsequenceDPTopDown implements LongestPalindromicSubsequence {

        @Override
        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            return longestPalindromeSubseq(s, 0, n - 1, new Integer[n][n]);
        }

        private int longestPalindromeSubseq(String s, int start, int end, Integer[][] memo) {
            if (start > end) {
                return 0;
            }

            if (start == end) {
                return 1;
            }

            if (memo[start][end] != null) {
                return memo[start][end];
            }

            if (s.charAt(start) == s.charAt(end)) {
                // include the first and last characters in palindrome
                // and recur for the remaining substring s[start + 1 : end - 1]
                memo[start][end] = longestPalindromeSubseq(s, start + 1, end - 1, memo) + 2;
            } else {
                // option #1: remove the last character and recur for the remaining substring s[start : end - 1]
                // option #2: remove the first character and recur for the remaining substring s[start + 1 : end]
                // choose the maximum of the two values
                memo[start][end] = Math.max(
                        longestPalindromeSubseq(s, start + 1, end, memo),
                        longestPalindromeSubseq(s, start, end - 1, memo));
            }
            return memo[start][end];
        }
    }

    class LongestPalindromicSubsequenceDPBottomUp implements LongestPalindromicSubsequence {

        @Override
        public int longestPalindromeSubseq(String s) {
            int n = s.length();

            // dp[i][j] is the Longest Palindromic Subsequence in s[i : j] substring
            int[][] dp = new int[n][n];
            for (int len = 1; len <= n; len++) {
                for (int start = 0; start <= n - len; start++) {
                    int end = start + len - 1;
                    if (s.charAt(start) == s.charAt(end)) {
                        dp[start][end] = (len > 1) ? 2 + dp[start + 1][end - 1] : 1;
                    } else {
                        dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
