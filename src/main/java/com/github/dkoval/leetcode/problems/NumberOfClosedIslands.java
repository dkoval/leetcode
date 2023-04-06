package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Queue;

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
            for (int row = 1; row < m - 1; row++) {
                for (int col = 1; col < n - 1; col++) {
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

    class NumberOfClosedIslandsBFS implements NumberOfClosedIslands {

        // (dx, dy): up, down, left, right
        private static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int closedIsland(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int count = 0;
            boolean[][] visited = new boolean[m][n];

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 0 && !visited[row][col]) {
                        boolean closed = bfs(grid, row, col, visited);
                        if (closed) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }

        private boolean bfs(int[][] grid, int row, int col, boolean[][] visited) {
            int m = grid.length;
            int n = grid[0].length;

            boolean closed = true;
            Queue<Cell> q = new ArrayDeque<>();
            q.offer(new Cell(row, col));
            visited[row][col] = true;
            while (!q.isEmpty()) {
                Cell curr = q.poll();
                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                        if (grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                            q.offer(new Cell(nextRow, nextCol));
                            visited[nextRow][nextCol] = true;
                        }
                    } else {
                        // out of bounds
                        closed = false;
                    }
                }
            }
            return closed;
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
