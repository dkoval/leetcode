package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/magic-squares-in-grid/">Magic Squares In Grid</a>
 * <p>
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column,
 * and both diagonals all have the same sum.
 * <p>
 * Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?
 * <p>
 * Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.
 * <p>
 * Constraints:
 * <ul>
 *  <li><row == grid.length</li>
 *  <li><col == grid[i].length</li>
 *  <li><1 <= row, col <= 10</li>
 *  <li><0 <= grid[i][j] <= 15</li>
 * </ul>
 */
public interface MagicSquaresInGrid {

    int numMagicSquaresInside(int[][] grid);

    class MagicSquaresInGridRev1 implements MagicSquaresInGrid {

        @Override
        public int numMagicSquaresInside(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int count = 0;
            for (int row = 0; row <= m - 3; row++) {
                for (int col = 0; col <= n - 3; col++) {
                    if (isMagicSquare(grid, row, col)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isMagicSquare(int[][] grid, int startRow, int startCol) {
            // cols[j] is the sum of numbers in the j-th column
            int[] colSums = new int[3];
            // diagSums[0] - sum of the numbers on (0, 0) -> (1, 1) -> (2, 2) diagonal
            // diagSums[1] - sum of the numbers on (0, 2) -> (1, 1) -> (2, 0) diagonal
            int[] diagSums = new int[2];
            // frequencies of numbers in 3x3 grid
            int[] counts = new int[10];

            int targetSum = -1;
            for (int row = startRow; row < startRow + 3; row++) {
                int rowSum = 0;
                for (int col = startCol; col < startCol + 3; col++) {
                    if (grid[row][col] == 0 || grid[row][col] > 9 || ++counts[grid[row][col]] > 1) {
                        return false;
                    }

                    rowSum += grid[row][col];
                    colSums[col - startCol] += grid[row][col];

                    if (row - startRow - col + startCol == 0) {
                        diagSums[0] += grid[row][col];
                    }

                    if (row - startRow + col - startCol == 2) {
                        diagSums[1] += grid[row][col];
                    }
                }

                if (targetSum == -1) {
                    targetSum = rowSum;
                } else if (rowSum != targetSum) {
                    return false;
                }
            }

            for (int colSum : colSums) {
                if (colSum != targetSum) {
                    return false;
                }
            }

            for (int diagSum : diagSums) {
                if (diagSum != targetSum) {
                    return false;
                }
            }
            return true;
        }
    }
}
