package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/number-of-enclaves/">Number of Enclaves</a>
 * <p>
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * <p>
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * <p>
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 500</li>
 *  <li>grid[i][j] is either 0 or 1</li>
 * </ul>
 */
public interface NumberOfEnclaves {

    int numEnclaves(int[][] grid);

    class NumberOfEnclavesDFS implements NumberOfEnclaves {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        @Override
        public int numEnclaves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // cells on the borders can't belong to enclaves,
            // therefore explore them first to mark for exclusion
            for (int col = 0; col < n; col++) {
                // first row
                if (grid[0][col] == 1) {
                    dfs(grid, 0, col);
                }
                // last row
                if (grid[m - 1][col] == 1) {
                    dfs(grid, m - 1, col);
                }
            }

            for (int row = 0; row < m; row++) {
                // first column
                if (grid[row][0] == 1) {
                    dfs(grid, row, 0);
                }
                // last column
                if (grid[row][n - 1] == 1) {
                    dfs(grid, row, n - 1);
                }
            }

            // count cells for which we cannot walk off the boundary of the grid
            int count = 0;
            for (int row = 1; row < m - 1; row++) {
                for (int col = 1; col < n - 1; col++) {
                    if (grid[row][col] == 1) {
                        count += dfs(grid, row, col);
                    }
                }
            }
            return count;
        }

        private int dfs(int[][] grid, int row, int col) {
            int m = grid.length;
            int n = grid[0].length;

            int count = 1;
            grid[row][col] = 2;
            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] != 1) {
                    continue;
                }
                count += dfs(grid, nextRow, nextCol);
            }
            return count;
        }
    }

    class NumberOfEnclavesBFS implements NumberOfEnclaves {

        // up, down left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int numEnclaves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int count = 0;
            boolean[][] visited = new boolean[m][n];
            for (int row  = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1 && !visited[row][col]) {
                        count += bfs(grid, row, col, visited);
                    }
                }
            }
            return count;
        }

        private int bfs(int[][] grid, int row, int col, boolean[][] visited) {
            int m = grid.length;
            int n = grid[0].length;

            int count = 0;
            boolean walkOff = false;

            Queue<Cell> q = new ArrayDeque<>();
            q.offer(new Cell(row, col));
            visited[row][col] = true;
            while (!q.isEmpty()) {
                Cell curr = q.poll();
                count++;

                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                        if (grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                            q.offer(new Cell(nextRow, nextCol));
                            visited[nextRow][nextCol] = true;
                        }
                    } else {
                        walkOff = true;
                    }
                }
            }
            return walkOff ? 0 : count;
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
