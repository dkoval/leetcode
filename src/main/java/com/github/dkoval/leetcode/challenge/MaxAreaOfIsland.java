package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3764/">Max Area of Island</a>
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {

    private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int currArea = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int col) {
        // boundary check
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return 0;
        }

        if (grid[row][col] == 0 || grid[row][col] == -1) {
            return 0;
        }

        // mark cell (row, col) as visited
        grid[row][col] *= -1;

        // explore island further out by checking 4-directionally connected cells
        int area = 1;
        for (int[] d : DIRECTIONS) {
            area += dfs(grid, row + d[0], col + d[1]);
        }
        return area;
    }
}
