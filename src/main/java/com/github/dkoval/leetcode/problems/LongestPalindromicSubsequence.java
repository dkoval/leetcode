package com.github.dkoval.leetcode.problems;

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

        private int longestPalindromeSubseq(String s, int i, int j, Integer[][] memo) {
            if (i > j) {
                return 0;
            }

            if (i == j) {
                return 1;
            }

            if (memo[i][j] != null) {
                return memo[i][j];
            }

            if (s.charAt(i) == s.charAt(j)) {
                // include the first and last characters in palindrome
                // and recur for the remaining substring s[i + 1 : j - 1]
                memo[i][j] = longestPalindromeSubseq(s, i + 1, j - 1, memo) + 2;
            } else {
                // option #1: remove the last character and recur for the remaining substring s[i : j - 1]
                // option #2: remove the first character and recur for the remaining substring s[i + 1 : j]
                // choose the maximum of the two values
                memo[i][j] = Math.max(
                        longestPalindromeSubseq(s, i + 1, j, memo),
                        longestPalindromeSubseq(s, i, j - 1, memo));
            }
            return memo[i][j];
        }
    }

    class LongestPalindromicSubsequenceDPBottomUp implements LongestPalindromicSubsequence {

        @Override
        public int longestPalindromeSubseq(String s) {
            return 0;
        }
    }
}
