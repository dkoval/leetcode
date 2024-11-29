package com.github.dkoval.leetcode.challenge;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/">Minimum Time to Visit a Cell In a Grid (Hard)</a>
 * <p>
 * You are given a m x n matrix grid consisting of non-negative integers where grid[row][col] represents the minimum time
 * required to be able to visit the cell (row, col), which means you can visit the cell (row, col) only when the time
 * you visit it is greater than or equal to grid[row][col].
 * <p>
 * You are standing in the top-left cell of the matrix in the 0th second, and you must move to any adjacent cell
 * in the four directions: up, down, left, and right. Each move you make takes 1 second.
 * <p>
 * Return the minimum time required in which you can visit the bottom-right cell of the matrix.
 * If you cannot visit the bottom-right cell, then return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>2 <= m, n <= 1000</li>
 *  <li>4 <= m * n <= 10^5</li>
 *  <li>0 <= grid[i][j] <= 10^5</li>
 *  <li>grid[0][0] == 0</li>
 * </ul>
 */
public interface MinimumTimeToVisitCellInGrid {

    int minimumTime(int[][] grid);

    // Explanation: https://youtu.be/Kj98r8IgJOQ?si=7u4gjQmVbJ-esqJX
    // O(M * N * log (M * N)) time | O(M * N) space
    class MinimumTimeToVisitCellInGridRev1 implements MinimumTimeToVisitCellInGrid {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int minimumTime(int[][] grid) {
            // Corner case: can't make the 1st move
            if (Math.min(grid[0][1], grid[1][0]) > 1) {
                return -1;
            }

            // 2 <= m, n <= 1000
            var m = grid.length;
            var n = grid[0].length;

            // Idea: Dijkstra's algorithm
            var q = new PriorityQueue<Cell>(Comparator.comparingInt(it -> it.time));
            var times = new Integer[m][n];

            q.offer(new Cell(0, 0, 0));
            times[0][0] = 0;

            while (!q.isEmpty()) {
                var curr = q.poll();

                if (curr.row == m - 1 && curr.col == n - 1) {
                    return curr.time;
                }

                for (var d : DIRS) {
                    var nextRow = curr.row + d[0];
                    var nextCol = curr.col + d[1];

                    // out of bounds?
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    var nextTime = curr.time + 1;
                    if (curr.time < grid[nextRow][nextCol]) {
                        // need to wait by going back and forth between (currRow, currCol) and any other adjacent cell
                        // (always possible) to unlock a move to (nextRow, nextCol)
                        var diff = Math.abs(curr.time - grid[nextRow][nextCol]);
                        var extra = (diff % 2 == 0) ? 1 : 0;
                        nextTime = grid[nextRow][nextCol] + extra;
                    }

                    if (times[nextRow][nextCol] == null || nextTime < times[nextRow][nextCol]) {
                        q.offer(new Cell(nextTime, nextRow, nextCol));
                        times[nextRow][nextCol] = nextTime;
                    }
                }
            }
            return times[m - 1][n - 1];
        }

        private record Cell(int time, int row, int col) {
        }
    }
}
