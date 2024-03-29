package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix-ii/">Spiral Matrix II</a>
 * <p>
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 20</li>
 * </ul>
 */
public interface SpiralMatrix2 {

    int[][] generateMatrix(int n);

    class SpiralMatrix2Rev1 implements SpiralMatrix2 {

        @Override
        public int[][] generateMatrix(int n) {
            int startRow = 0, endRow = n - 1;
            int startCol = 0, endCol = n - 1;

            int x = 1;
            int[][] ans = new int[n][n];
            while (startRow <= endRow && startCol <= endCol) {
                // top row - left to right
                for (int col = startCol; col <= endCol; col++) {
                    ans[startRow][col] = x++;
                }

                // right column - top to bottom
                for (int row = startRow + 1; row <= endRow; row++) {
                    ans[row][endCol] = x++;
                }

                // bottom row - right to left
                for (int col = endCol - 1; col >= startCol && startRow != endRow; col--) {
                    ans[endRow][col] = x++;
                }

                // left column - bottom to up
                for (int row = endRow - 1; row > startRow && startCol != endCol; row--) {
                    ans[row][startCol] = x++;
                }

                startRow++;
                endRow--;

                startCol++;
                endCol--;
            }
            return ans;
        }
    }
}
