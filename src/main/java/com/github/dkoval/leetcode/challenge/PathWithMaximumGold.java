package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/path-with-maximum-gold/description/">Path with Maximum Gold</a>
 * <p>
 * In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell,
 * 0 if it is empty.
 * <p>
 * Return the maximum amount of gold you can collect under the conditions:
 * <ul>
 *  <li>Every time you are located in a cell you will collect all the gold in that cell.</li>
 *  <li>From your position, you can walk one step to the left, right, up, or down.</li>
 *  <li>You can't visit the same cell more than once.</li>
 *  <li>Never visit a cell with 0 gold.</li>
 *  <li>You can start and stop collecting gold from any position in the grid that has some gold.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 15</li>
 *  <li>0 <= grid[i][j] <= 100</li>
 *  <li>There are at most 25 cells containing gold.</li>
 * </ul>
 */
public interface PathWithMaximumGold {

    // up, down, left, right
    int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int getMaximumGold(int[][] grid);

    class PathWithMaximumGoldRev1 implements PathWithMaximumGold {

        @Override
        public int getMaximumGold(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[] best = {0};
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] > 0) {
                        traverse(grid, row, col, grid[row][col], best);
                    }
                }
            }
            return best[0];
        }

        private void traverse(int[][] grid, int row, int col, int totalGold, int[] best) {
            int m = grid.length;
            int n = grid[0].length;

            best[0] = Math.max(best[0], totalGold);

            // mark current cell as visited
            grid[row][col] *= -1;
            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] > 0) {
                    traverse(grid, nextRow, nextCol, totalGold + grid[nextRow][nextCol], best);
                }
            }
            // backtrack
            grid[row][col] *= -1;
        }
    }

    class PathWithMaximumGoldRev2 implements PathWithMaximumGold {

        @Override
        public int getMaximumGold(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int best = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] > 0) {
                        best = Math.max(best, traverse(grid, row, col));
                    }
                }
            }
            return best;
        }

        private int traverse(int[][] grid, int row, int col) {
            int m = grid.length;
            int n = grid[0].length;

            // mark current cell as visited
            grid[row][col] *= -1;

            int extra = 0;
            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] > 0) {
                    extra = Math.max(extra, traverse(grid, nextRow, nextCol));
                }
            }

            // backtrack
            grid[row][col] *= -1;
            return grid[row][col] + extra;
        }
    }
}
