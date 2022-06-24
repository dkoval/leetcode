package com.github.dkoval.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.BiConsumer;

/**
 * <a href="https://leetcode.com/problems/shortest-bridge/">Shortest Bridge</a>
 * <p>
 * You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
 * <p>
 * An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
 * <p>
 * You may change 0's to 1's to connect the two islands to form one island.
 * <p>
 * Return the smallest number of 0's you must flip to connect the two islands.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == grid.length == grid[i].length</li>
 *  <li>2 <= n <= 100</li>
 *  <li>grid[i][j] is either 0 or 1</li>
 *  <li>There are exactly two islands in grid</li>
 * </ul>
 */
public interface ShortestBridge {

    int shortestBridge(int[][] grid);

    // O(N^2) time | O(N^2) space
    class ShortestBridgeUsingDFSAndBFS implements ShortestBridge {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        private static final int LAND = 1;
        private static final int WATER = 0;

        private static class Cell {
            final int row;
            final int col;
            final int dist;

            Cell(int row, int col, int dist) {
                this.row = row;
                this.col = col;
                this.dist = dist;
            }
        }

        @Override
        public int shortestBridge(int[][] grid) {
            int n = grid.length;

            int[] id = {-1};
            Queue<Cell> q = new ArrayDeque<>();
            BiConsumer<Integer, Integer> doOnNext = (row, col) -> {
                if (id[0] == -1) {
                    // only collect cells forming the 1st island
                    q.offer(new Cell(row, col, 0));
                }
            };

            // DFS to identify the two islands of the grid
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == LAND) {
                        dfs(grid, row, col, id[0], doOnNext);
                        id[0]--;
                    }
                }
            }

            // BFS to find the shortest path between the two islands
            return bfs(grid, q);
        }

        private void dfs(int[][] grid, int row, int col, int id, BiConsumer<Integer, Integer> doOnNext) {
            int n = grid.length;

            // mark current cell as visited
            grid[row][col] = id;
            doOnNext.accept(row, col);

            for (int[] d : DIRS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] != LAND) {
                    continue;
                }

                dfs(grid, nextRow, nextCol, id, doOnNext);
            }
        }

        private int bfs(int[][] grid, Queue<Cell> q) {
            int n = grid.length;

            // id = -1 - visited 1st island's cell
            // id = -2 - visited 2nd island's cell
            // id = -3 - visited water call
            while (!q.isEmpty()) {
                Cell curr = q.poll();
                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    // check boundaries
                    if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    // already visited?
                    if (grid[nextRow][nextCol] == -1 || grid[nextRow][nextCol] == -3) {
                        continue;
                    }

                    if (grid[nextRow][nextCol] == -2) {
                        // reached the 2nd island
                        return curr.dist;
                    }

                    grid[nextRow][nextCol] = -3;
                    q.offer(new Cell(nextRow, nextCol, curr.dist + 1));
                }
            }
            return 42;
        }
    }
}
