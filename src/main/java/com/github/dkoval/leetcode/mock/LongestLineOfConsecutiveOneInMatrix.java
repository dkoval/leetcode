package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/">Longest Line of Consecutive One in Matrix</a>
 *
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix.
 * The line could be horizontal, vertical, diagonal or anti-diagonal.
 */
public abstract class LongestLineOfConsecutiveOneInMatrix {

    public abstract int longestLine(int[][] M);

    // Time complexity : O(M*N). We traverse the entire matrix once only.
    // Space complexity : O(M*N) to store DP array
    public static class LongestLineOfConsecutiveOneInMatrixUsing3DDynamicProgramming extends LongestLineOfConsecutiveOneInMatrix {

        @Override
        public int longestLine(int[][] M) {
            if (M.length == 0) return 0;
            int m = M.length, n = M[0].length;
            // dp[i][j][0], dp[i][j][1], dp[i][j][2] ,dp[i][j][3] store the maximum number of continuous 1's found so far
            // along the Horizontal, Vertical, Diagonal and Anti-diagonal lines respectively
            int globalMax = 0;
            int[][][] dp = new int[m][n][4];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (M[i][j] == 1) {
                        // horizontal
                        dp[i][j][0] = (j > 0) ? dp[i][j - 1][0] + 1 : 1;
                        // vertical
                        dp[i][j][1] = (i > 0) ? dp[i - 1][j][1] + 1 : 1;
                        // diagonal
                        dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
                        // anti-diagonal
                        dp[i][j][3] = (i > 0 && j < n - 1) ? dp[i - 1][j + 1][3] + 1 : 1;

                        int localMax = Math.max(dp[i][j][0], dp[i][j][1]);
                        localMax = Math.max(localMax, dp[i][j][2]);
                        localMax = Math.max(localMax, dp[i][j][3]);

                        globalMax = Math.max(globalMax, localMax);
                    }
                }
            }
            return globalMax;
        }
    }
}
