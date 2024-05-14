package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/score-after-flipping-matrix/">Score After Flipping Matrix</a>
 * <p>
 * You are given an m x n binary matrix grid.
 * <p>
 * A move consists of choosing any row or column and toggling each value in that row or column
 * (i.e., changing all 0's to 1's, and all 1's to 0's).
 * <p>
 * Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
 * <p>
 * Return the highest possible score after making any number of moves (including zero moves).
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 20</li>
 *  <li>grid[i][j] is either 0 or 1</li>
 * </ul>
 */
public interface ScoreAfterFlippingMatrix {

    int matrixScore(int[][] grid);

    // 0(M * N + N) time | O(N) space
    class ScoreAfterFlippingMatrixRev1 implements ScoreAfterFlippingMatrix {

        private static int getScore(int n, int[] cols, int m) {
            // j-th column corresponds to (n - j - 1)-th bit in a binary number;
            // each i-th row represents a base 10 number:
            // x = row[0] * 2^(n - 1) + row[1] * 2^(n - 2) + ... + row[n - 2] * 2^1 + row[n - 1] * 2^0
            int score = 0;
            for (int j = 0; j < n; j++) {
                int k = n - j - 1;
                // max number of 1's we can have in each column
                int count = Math.max(cols[j], m - cols[j]);
                // 1 << k = 2^k
                score += (1 << k) * count;
            }
            return score;
        }

        @Override
        public int matrixScore(int[][] grid) {
            // idea: greedy
            int m = grid.length;
            int n = grid[0].length;

            // process rows - turn the most significant bits to 1's
            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 0) {
                    // flip bits in this row
                    for (int j = 0; j < n; j++) {
                        grid[i][j] = 1 - grid[i][j];
                    }
                }
            }

            // process columns - count the number of 1's in each column
            int[] cols = new int[n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    cols[j] += grid[i][j];
                }
            }

            return getScore(n, cols, m);
        }
    }
}
