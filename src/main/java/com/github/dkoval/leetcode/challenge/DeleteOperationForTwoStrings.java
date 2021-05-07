package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3734/">Delete Operation for Two Strings</a>
 * <p>
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 * <p>
 * In one step, you can delete exactly one character in either string.
 */
public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        // DP bottom-up
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] - min number of deletions required to make word1[0:i] and word2[0:j] the same
        int[][] dp = new int[m + 1][n + 1];

        // 1st row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        // 1st col
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (word1.charAt(i - 1) == word2.charAt(j - 1))
                        ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[m][n];
    }
}
