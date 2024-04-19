package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">Number of Islands</a>
 * <p>
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 300</li>
 *  <li>grid[i][j] is '0' or '1'</li>
 * </ul>
 */
public interface NumberOfIslands {

    int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    int numIslands(char[][] grid);

    class NumberOfIslandsDFS implements NumberOfIslands {

        @Override
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

    class NumberOfIslandBFS implements NumberOfIslands {

        @Override
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int islands = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == '1') {
                        bfs(grid, row, col);
                        islands++;
                    }
                }
            }
            return islands;
        }

        private void bfs(char[][] grid, int row, int col) {
            int m = grid.length;
            int n = grid[0].length;

            // BFS
            Queue<Cell> q = new ArrayDeque<>();
            q.offer(new Cell(row, col));
            grid[row][col] = '#';
            while (!q.isEmpty()) {
                Cell curr = q.poll();
                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    if (nextRow < 0 || nextRow == m || nextCol < 0 || nextCol == n || grid[nextRow][nextCol] != '1') {
                        continue;
                    }

                    q.offer(new Cell(nextRow, nextCol));
                    grid[nextRow][nextCol] = '#';
                }
            }
        }

        private static record Cell(int row, int col) {}
    }
}
