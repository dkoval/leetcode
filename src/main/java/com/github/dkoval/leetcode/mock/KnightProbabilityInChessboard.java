package com.github.dkoval.leetcode.mock;

public abstract class KnightProbabilityInChessboard {

    public abstract double knightProbability(int N, int K, int r, int c);

    public static class KnightProbabilityInChessboardUsing2DArray extends KnightProbabilityInChessboard {

        private static final int[][] dirs = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

        // LeetCode: https://leetcode.com/problems/knight-probability-in-chessboard/
        public double knightProbability(int N, int K, int r, int c) {
            // dp[i][j] - probability of being on square (i, j)
            double[][] dp = new double[N][N];
            dp[r][c] = 1.0;
            while (K-- > 0) {
                double[][] newDp = new double[N][N];
                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < N; col++) {
                        for (int[] dir : dirs) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];
                            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                                newDp[newRow][newCol] += dp[row][col] / 8.0;
                            }
                        }
                    }
                }
                dp = newDp;
            }
            // sum probabilities
            double result = 0.0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result += dp[i][j];
                }
            }
            return result;
        }
    }
}
