package com.github.dkoval.leetcode.mock;

/**
 * <a href="https://leetcode.com/problems/knight-probability-in-chessboard/">Knight Probability in Chessboard</a>
 * <p>
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
 * The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * <p>
 * A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
 * then one square in an orthogonal direction.
 * <p>
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random
 * (even if the piece would go off the chessboard) and moves there.
 * <p>
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard.
 * Return the probability that the knight remains on the board after it has stopped moving.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 25</li>
 *  <li>0 <= k <= 100</li>
 *  <li>0 <= row, column <= n - 1</li>
 * </ul>
 */
public interface KnightProbabilityInChessboard {

    double knightProbability(int N, int K, int r, int c);

    class KnightProbabilityInChessboardUsing2DArray implements KnightProbabilityInChessboard {

        private static final int[][] DIRS = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

        // Resource: https://www.youtube.com/watch?v=OrS7PaJ-5ck
        public double knightProbability(int N, int K, int r, int c) {
            // dp[i][j] - probability of being on square (i, j)
            double[][] dp = new double[N][N];
            dp[r][c] = 1.0;
            while (K-- > 0) {
                double[][] newDp = new double[N][N];
                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < N; col++) {
                        if (dp[row][col] == 0) continue;
                        for (int[] dir : DIRS) {
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

    class KnightProbabilityInChessboardDPTopDown implements KnightProbabilityInChessboard {

        private static final int[][] DIRS = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

        @Override
        public double knightProbability(int n, int k, int row, int col) {
            // Idea: DP top-down
            Double[][][] dp = new Double[k + 1][n][n];
            return calculate(n, k, row, col, dp);
        }

        private double calculate(int n, int k, int row, int col, Double[][][] dp) {
            if (k == 0) {
                return 1.0;
            }

            // already solved?
            if (dp[k][row][col] != null) {
                return dp[k][row][col];
            }

            // moves are independent => sum the probabilities of moves
            double p = 0.0;
            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
                    p += calculate(n, k - 1, nextRow, nextCol, dp);
                }
            }

            // a chess knight has eight possible moves
            return dp[k][row][col] = p / 8;
        }
    }
}
