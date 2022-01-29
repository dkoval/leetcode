package com.github.dkoval.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 * <p>
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        // check boundaries
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        if (grid[row][col] != '1') {
            return;
        }

        // mark current cell as visited
        grid[row][col] = '#';

        // explore adjacent cells
        for (int[] d : DIRS) {
            dfs(grid, row + d[0], col + d[1]);
        }
    }
}
