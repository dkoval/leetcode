package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/number-of-closed-islands/">Number of Closed Islands</a>
 * <p>
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s
 * and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * <p>
 * Return the number of closed islands.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= grid.length, grid[0].length <= 100</li>
 *  <li>0 <= grid[i][j] <= 1</li>
 * </ul>
 */
public interface NumberOfClosedIslands {

    int closedIsland(int[][] grid);

    class NumberOfClosedIslandsDFS implements NumberOfClosedIslands {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        private static final int LAND = 0;
        private static final int VISITED = 2;

        @Override
        public int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // cells on the borders can't belong to closed islands,
            // therefore explore them first to mark for exclusion
            for (int col = 0; col < n; col++) {
                // first row
                if (grid[0][col] == LAND) {
                    dfs(grid, 0, col);
                }
                // last row
                if (grid[m - 1][col] == LAND) {
                    dfs(grid, m - 1, col);
                }
            }

            for (int row = 0; row < m; row++) {
                // first column
                if (grid[row][0] == LAND) {
                    dfs(grid, row, 0);
                }
                // last column
                if (grid[row][n - 1] == LAND) {
                    dfs(grid, row, n - 1);
                }
            }

            // count closed islands
            int count = 0;
            for (int row = 1; row < m; row++) {
                for (int col = 1; col < n; col++) {
                    if (grid[row][col] == LAND) {
                        dfs(grid, row, col);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] grid, int row, int col) {
            int m = grid.length;
            int n = grid[0].length;

            grid[row][col] = VISITED;
            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] != LAND) {
                    continue;
                }
                dfs(grid, nextRow, nextCol);
            }
        }
    }
}
