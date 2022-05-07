package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="Pacific Atlantic Water Flow/">Pacific Atlantic Water Flow</a>
 * <p>
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * <p>
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == heights.length</li>
 *  <li>n == heights[r].length</li>
 *  <li>1 <= m, n <= 200</li>
 *  <li>0 <= heights[r][c] <= 10^5</li>
 * </ul>
 */
public class PacificAtlanticWaterFlow {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] cameFromPacific = new boolean[m][n];
        boolean[][] cameFromAtlantic = new boolean[m][n];

        for (int col = 0; col < n; col++) {
            // 1st row: flow from Pacific
            dfs(heights, 0, col, cameFromPacific);
            // last row: flow from Atlantic
            dfs(heights, m - 1, col, cameFromAtlantic);
        }

        for (int row = 0; row < m; row++) {
            // 1st column: flow from Pacific
            dfs(heights, row, 0, cameFromPacific);
            // last column: flow from Atlantic
            dfs(heights, row, n - 1, cameFromAtlantic);
        }

        // merge individual results
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (cameFromPacific[row][col] && cameFromAtlantic[row][col]) {
                    ans.add(Arrays.asList(row, col));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;

        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        for (int[] d : DIRS) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];

            // check boundaries
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                continue;
            }

            if (heights[nextRow][nextCol] >= heights[row][col]) {
                dfs(heights, nextRow, nextCol, visited);
            }
        }
    }
}