package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/count-sub-islands/">Count Sub Islands</a>
 * <p>
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land).
 * An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
 * <p>
 * An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
 * <p>
 * Return the number of islands in grid2 that are considered sub-islands.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid1.length == grid2.length</li>
 *  <li>n == grid1[i].length == grid2[i].length</li>
 *  <li>1 <= m, n <= 500</li>
 *  <li>grid1[i][j] and grid2[i][j] are either 0 or 1</li>
 * </ul>
 */
public interface CountSubIslands {

    int countSubIslands(int[][] grid1, int[][] grid2);

    class CountSubIslandsDFS implements CountSubIslands {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        @Override
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int m = grid2.length;
            int n = grid2[0].length;

            int count = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid2[row][col] == 1) {
                        count += dfs(grid2, row, col, grid1) ? 1 : 0;
                    }
                }
            }
            return count;
        }

        private boolean dfs(int[][] grid2, int row, int col, int[][] grid1) {
            int m = grid2.length;
            int n = grid2[0].length;

            boolean isSubIsland = true;
            grid2[row][col] = 2;

            if (grid1[row][col] == 0) {
                isSubIsland = false;
            }

            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];

                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid2[nextRow][nextCol] != 1) {
                    continue;
                }

                isSubIsland &= dfs(grid2, nextRow, nextCol, grid1);
            }
            return isSubIsland;
        }
    }

    class CountSubIslandsBFS implements CountSubIslands {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        @Override
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            int m2 = grid2.length;
            int n2 = grid2[0].length;

            int count = 0;
            for (int row = 0; row < m2; row++) {
                for (int col = 0; col < n2; col++) {
                    if (grid2[row][col] == 1) {
                        count += bfs(grid2, row, col, grid1) ? 1 : 0;
                    }
                }
            }
            return count;
        }

        private boolean bfs(int[][] grid2, int row, int col, int[][] grid1) {
            int m2 = grid2.length;
            int n2 = grid2[0].length;

            Queue<Cell> q = new ArrayDeque<>();
            q.offer(new Cell(row, col));
            // mark (row, col) cell in grid2 as visited
            grid2[row][col] = 2;

            boolean subIsland = true;
            while (!q.isEmpty()) {
                Cell curr = q.poll();

                if (grid1[curr.row][curr.col] != 1) {
                    subIsland = false;
                }

                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    if (nextRow < 0 || nextRow >= m2 || nextCol < 0 || nextCol >= n2) {
                        continue;
                    }

                    if (grid2[nextRow][nextCol] != 1) {
                        continue;
                    }

                    q.offer(new Cell(nextRow, nextCol));
                    grid2[nextRow][nextCol] = 2;
                }
            }

            return subIsland;
        }

        private record Cell(int row, int col) {
        }
    }
}
