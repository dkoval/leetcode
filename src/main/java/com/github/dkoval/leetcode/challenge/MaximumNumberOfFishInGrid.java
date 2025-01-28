package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/">Maximum Number of Fish in a Grid</a>
 * <p>
 * You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:
 * <ul>
 *  <li>A land cell if grid[r][c] = 0, or</li>
 *  <li>A water cell containing grid[r][c] fish, if grid[r][c] > 0.</li>
 * </ul>
 * A fisher can start at any water cell (r, c) and can do the following operations any number of times:
 * <ul>
 *  <li>Catch all the fish at cell (r, c), or</li>
 *  <li>Move to any adjacent water cell.</li>
 * </ul>
 * Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.
 * <p>
 * An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 10</li>
 *  <li>0 <= grid[i][j] <= 10</li>
 * </ul>
 */
public interface MaximumNumberOfFishInGrid {

    int findMaxFish(int[][] grid);

    class MaximumNumberOfFishInGridRev1 implements MaximumNumberOfFishInGrid {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int findMaxFish(int[][] grid) {
            final var m = grid.length;
            final var n = grid[0].length;

            var best = 0;
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    if (grid[row][col] > 0) {
                        var res = dfs(grid, row, col);
                        best = Math.max(best, res);
                    }
                }
            }
            return best;
        }

        private int dfs(int[][] grid, int row, int col) {
            final var m = grid.length;
            final var n = grid[0].length;

            var total = grid[row][col];
            grid[row][col] *= -1; // mark (row, col) as visited
            for (var d : DIRS) {
                var nextRow = row + d[0];
                var nextCol = col + d[1];

                // out of bounds?
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                    continue;
                }

                // land or visited?
                if (grid[nextRow][nextCol] <= 0) {
                    continue;
                }

                total += dfs(grid, nextRow, nextCol);
            }
            return total;
        }
    }
}
