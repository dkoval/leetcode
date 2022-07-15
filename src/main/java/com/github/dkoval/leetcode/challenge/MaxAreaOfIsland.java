package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/">Max Area of Island</a>
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 50</li>
 *  <li>grid[i][j] is either 0 or 1</li>
 * </ul>
 */
public interface MaxAreaOfIsland {

    int maxAreaOfIsland(int[][] grid);

    class MaxAreaOfIslandDFS implements MaxAreaOfIsland {
        private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        @Override
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int maxArea = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        int area = dfs(grid, row, col);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
            return maxArea;
        }

        private int dfs(int[][] grid, int row, int col) {
            int m = grid.length;
            int n = grid[0].length;

            grid[row][col] = -1; // mark as visited
            int area = 1;
            for (int[] d : DIRECTIONS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1) {
                    area += dfs(grid, nextRow, nextCol);
                }
            }
            return area;
        }
    }

    class MaxAreaOfIslandBFS implements MaxAreaOfIsland {
        private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        @Override
        public int maxAreaOfIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int maxArea = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        int area = bfs(grid, row, col);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
            return maxArea;
        }

        private int bfs(int[][] grid, int row, int col) {
            int m = grid.length;
            int n = grid[0].length;

            int area = 0;
            Queue<Cell> q = new ArrayDeque<>();
            q.offer(new Cell(row, col));
            grid[row][col] = -1; // mark as visited
            while (!q.isEmpty()) {
                Cell curr = q.poll();
                area++;
                for (int[] d : DIRECTIONS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1) {
                        q.offer(new Cell(nextRow, nextCol));
                        grid[nextRow][nextCol] = -1;
                    }
                }
            }
            return area;
        }

        private static class Cell {
            final int row;
            final int col;

            Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
    }
}
