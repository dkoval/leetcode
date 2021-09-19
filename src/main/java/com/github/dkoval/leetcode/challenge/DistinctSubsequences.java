package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3980/">Distinct Subsequences</a>
 * <p>
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * <p>
 * A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters
 * without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * It is guaranteed the answer fits on a 32-bit signed integer.
 */
public interface DistinctSubsequences {

    int numDistinct(String s, String t);

    // O(N * M) time | O(N * M) space
    class DistinctSubsequencesBottomUp implements DistinctSubsequences {

        @Override
        public int numDistinct(String s, String t) {
            // DP: bottom-up
            int n = s.length();
            int m = t.length();

            // dp[i][j] is the number of distinct subsequences of t[0:j] in s[0:i]
            int[][] dp = new int[n + 1][m + 1];

            // fill 1st column
            for (int i = 0; i <= n; i++) {
                // there's only 1 way to obtain t = ""
                dp[i][0] = 1;
            }

            // fill 1st row
            for (int j = 1; j <= m; j++) {
                // there's no way to generate a non-empty string from s = ""
                dp[0][j] = 0;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (s.charAt(i - 1) != t.charAt(j - 1)) {
                        // don't take s[i], therefore the result doesn't change
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // case #1 - don't take s[i]: skip only i-th character from s
                        // case #2 - take s[i]: skip i-th character from s and j-th character from t
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    }
                }
            }

            return dp[n][m];
        }
    }

    // O(N * M) time | O(N * M) space
    class DistinctSubsequencesTopDownWithMemoization implements DistinctSubsequences {

        @Override
        public int numDistinct(String s, String t) {
            // DP: top-down with memoization
            int n = s.length();
            int m = t.length();
            Integer[][] memo = new Integer[n][m];
            return count(s, t, 0, 0, memo);
        }
        // i denotes s[i:] suffix
        // j denotes t[j:] suffix
        private int count(String s, String t, int i, int j, Integer[][] memo) {
            if (j == t.length()) {
                return 1;
            }

            if (i == s.length()) {
                return 0;
            }

            if (memo[i][j] != null) {
                return memo[i][j];
            }

            // don't take s[i]
            int count = count(s, t, i + 1, j, memo);
            if (s.charAt(i) == t.charAt(j)) {
                // take s[i] and proceed to the next character
                count += count(s, t, i + 1, j + 1, memo);
            }

            memo[i][j] = count;
            return count;
        }
    }
}
