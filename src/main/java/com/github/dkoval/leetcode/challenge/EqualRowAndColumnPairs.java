package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/equal-row-and-column-pairs/">Equal Row and Column Pairs</a>
 * <p>
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 * <p>
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == grid.length == grid[i].length</li>
 *  <li>1 <= n <= 200</li>
 *  <li>1 <= grid[i][j] <= 10^5</li>
 * </ul>
 */
public interface EqualRowAndColumnPairs {

    int equalPairs(int[][] grid);

    // O(N^3) time | O(N^2) time
    class EqualRowAndColumnPairsRev1 implements EqualRowAndColumnPairs {

        @Override
        public int equalPairs(int[][] grid) {
            int n = grid.length;

            int[][] cols = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cols[j][i] = grid[i][j];
                }
            }

            int count = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (arrayEquals(grid[r], cols[c])) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean arrayEquals(int[] row, int[] col) {
            int n = row.length;
            for (int i = 0; i < n; i++) {
                if (row[i] != col[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
