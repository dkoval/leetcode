package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/map-of-highest-peak/">Map of Highest Peak</a>
 * <p>
 * You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
 * <ul>
 *  <li>If isWater[i][j] == 0, cell (i, j) is a land cell.</li>
 *  <li>If isWater[i][j] == 1, cell (i, j) is a water cell.</li>
 * </ul>
 * You must assign each cell a height in a way that follows these rules:
 * <ul>
 *  <li>The height of each cell must be non-negative.</li>
 *  <li>If the cell is a water cell, its height must be 0.</li>
 *  <li>Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell
 *  if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
 *  </li>
 * </ul>
 * Find an assignment of heights such that the maximum height in the matrix is maximized.
 * <p>
 * Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height.
 * If there are multiple solutions, return any of them.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == isWater.length</li>
 *  <li>n == isWater[i].length</li>
 *  <li>1 <= m, n <= 1000</li>
 *  <li>isWater[i][j] is 0 or 1.</li>
 *  <li>There is at least one water cell.</li>
 * </ul>
 */
public interface MapOfHighestPeak {

    int[][] highestPeak(int[][] isWater);

    class MapOfHighestPeakRev1 implements MapOfHighestPeak {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int[][] highestPeak(int[][] isWater) {
            // idea: multi-source BFS
            final var m = isWater.length;
            final var n = isWater[0].length;

            final var q = new ArrayDeque<Cell>();
            final var visited = new boolean[m][n];
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    if (isWater[row][col] == 1) {
                        q.offer(new Cell(row, col, 0));
                        visited[row][col] = true;
                    }
                }
            }

            final var ans = new int[m][n];
            while (!q.isEmpty()) {
                final var curr = q.poll();
                for (var d : DIRS) {
                    final var nextRow = curr.row + d[0];
                    final var nextCol = curr.col + d[1];

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    // already visited?
                    if (visited[nextRow][nextCol]) {
                        continue;
                    }

                    ans[nextRow][nextCol] = curr.height + 1;
                    q.offer(new Cell(nextRow, nextCol, curr.height + 1));
                    visited[nextRow][nextCol] = true;
                }
            }
            return ans;
        }

        private record Cell(int row, int col, int height) {
        }
    }
}
