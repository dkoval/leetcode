package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/largest-magic-square/">Largest Magic Square</a>
 * <p>
 * A k x k magic square is a k x k grid filled with integers such that every row sum, every column sum, and both diagonal sums are all equal.
 * The integers in the magic square do not have to be distinct. Every 1 x 1 grid is trivially a magic square.
 * <p>
 * Given an m x n integer grid, return the size (i.e., the side length k) of the largest magic square that can be found within this grid.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 50</li>
 *  <li>1 <= grid[i][j] <= 10^6</li>
 * </ul>
 */
public interface LargestMagicSquare {

    int largestMagicSquare(int[][] grid);

    class LargestMagicSquareRev1 implements LargestMagicSquare {

        @Override
        public int largestMagicSquare(int[][] grid) {
            final var numRows = grid.length;
            final var numCols = grid[0].length;

            // preprocessing step
            final var prefixSumOfRows = new int[numRows][numCols];
            final var prefixSumOfCols = new int[numRows][numCols];
            final var prefixSumOfDiags1 = new int[numRows][numCols];
            final var prefixSumOfDiags2 = new int[numRows][numCols];

            for (var i = 0; i < numRows; i++) {
                for (var j = 0; j < numCols; j++) {
                    prefixSumOfRows[i][j] = grid[i][j] + (j > 0 ? prefixSumOfRows[i][j - 1] : 0);
                    prefixSumOfCols[i][j] = grid[i][j] + (i > 0 ? prefixSumOfCols[i - 1][j] : 0);
                    prefixSumOfDiags1[i][j] = grid[i][j] + (i > 0 && j > 0 ? prefixSumOfDiags1[i - 1][j - 1] : 0);
                    prefixSumOfDiags2[i][j] = grid[i][j] + (i > 0 && j < numCols - 1 ? prefixSumOfDiags2[i - 1][j + 1] : 0);
                }
            }

            // try every possible square with (i, j) as the top-left corner
            var best = 1;
            for (var i = 0; i < numRows; i++) {
                for (var j = 0; j < numCols; j++) {
                    // try every possible length of the square's side
                    for (var len = Math.min(numRows - i, numCols - j); len > 0; len--) {
                        final var diag1 = prefixSumOfDiags1[i + len - 1][j + len - 1] - (i > 0 && j > 0 ? prefixSumOfDiags1[i - 1][j - 1] : 0);
                        final var diag2 = prefixSumOfDiags2[i + len - 1][j] - (i > 0 && j + len < numCols ? prefixSumOfDiags2[i - 1][j + len] : 0);
                        if (diag1 != diag2) {
                            continue;
                        }

                        var good = true;
                        for (var row = i; row < i + len; row++) {
                            if (prefixSumOfRows[row][j + len - 1] - (j > 0 ? prefixSumOfRows[row][j - 1] : 0) != diag1) {
                                good = false;
                                break;
                            }
                        }

                        if (!good) {
                            continue;
                        }

                        good = true;
                        for (var col = j; col < j + len; col++) {
                            if (prefixSumOfCols[i + len - 1][col] - (i > 0 ? prefixSumOfCols[i - 1][col] : 0) != diag1) {
                                good = false;
                                break;
                            }
                        }

                        if (!good) {
                            continue;
                        }

                        best = Math.max(best, len);
                        break;
                    }
                }
            }
            return best;
        }
    }
}
