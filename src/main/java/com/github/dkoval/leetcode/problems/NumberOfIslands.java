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

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0' || grid[i][j] == '#') return;
        grid[i][j] = '#'; // mark as visited
        // look up
        if (i > 0) dfs(grid, i - 1, j);
        // look down
        if (i < grid.length - 1) dfs(grid, i + 1, j);
        // look left
        if (j > 0) dfs(grid, i, j - 1);
        // look right
        if (j < grid[0].length - 1) dfs(grid, i, j + 1);
    }
}
