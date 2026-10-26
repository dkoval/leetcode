package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/">Count Islands With Total Value Divisible by K</a>
 * <p>
 * You are given an m x n matrix grid and a positive integer k. An island is a group of positive integers (representing land) that are 4-directionally connected (horizontally or vertically).
 * <p>
 * The total value of an island is the sum of the values of all cells in the island.
 * <p>
 * Return the number of islands with a total value divisible by k.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 1000</li>
 *  <li>1 <= m * n <= 10^5</li>
 *  <li>0 <= grid[i][j] <= 10^6</li>
 *  <li>1 <= k <= 10^6</li>
 * </ul>
 */
public interface CountIslandsWithTotalValueDivisibleByK {

    int countIslands(int[][] grid, int k);

    class CountIslandsWithTotalValueDivisibleByKRev1 implements CountIslandsWithTotalValueDivisibleByK {

        // up, down, left, right
        private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int countIslands(int[][] grid, int k) {
            final var m = grid.length;
            final var n = grid[0].length;

            var count = 0;
            final var visited = new boolean[m][n];
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    if (grid[row][col] == 0 || visited[row][col]) {
                        continue;
                    }

                    final var sum = traverse(grid, k, row, col, visited);
                    if (sum == 0) {
                        count++;
                    }
                }
            }
            return count;
        }

        private int traverse(int[][] grid, int k, int sourceRow, int sourceCol, boolean[][] visited) {
            final var m = grid.length;
            final var n = grid[0].length;

            final var q = new ArrayDeque<Cell>();
            q.offer(new Cell(sourceRow, sourceCol));
            visited[sourceRow][sourceCol] = true;

            var sum = 0;
            while (!q.isEmpty()) {
                final var curr = q.poll();
                sum += grid[curr.row][curr.col];
                sum %= k;

                for (var d : DIRS) {
                    final var nextRow = curr.row + d[0];
                    final var nextCol = curr.col + d[1];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) {
                        continue;
                    }

                    if (grid[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                        continue;
                    }

                    q.offer(new Cell(nextRow, nextCol));
                    visited[nextRow][nextCol] = true;
                }
            }
            return sum;
        }

        private record Cell(int row, int col) {
        }
    }
}
