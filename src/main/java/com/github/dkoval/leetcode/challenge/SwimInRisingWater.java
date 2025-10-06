package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/swim-in-rising-water/">Swim in Rising Water (Hard)</a>
 * <p>
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
 * <p>
 * It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation
 * less than equal to t is submerged or reachable.
 * <p>
 * You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t.
 * You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 * <p>
 * Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= n <= 50</li>
 *  <li>0 <= grid[i][j] < n^2</li>
 *  <li>Each value grid[i][j] is unique</li>
 * </ul>
 */
public interface SwimInRisingWater {

    int swimInWater(int[][] grid);

    class SwimInRisingWaterDFSWithBinarySearchRev1 implements SwimInRisingWater {

        private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        @Override
        public int swimInWater(int[][] grid) {
            int n = grid.length;
            // binary search: find the minimum time from [0:N * N - 1] required to swim from (0, 0) to (N - 1, N - 1)
            int l = 0, r = n * n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                boolean[][] visited = new boolean[n][n];
                dfs(grid, 0, 0, mid, visited);
                if (visited[n - 1][n - 1]) {
                    // ok, can definitely swim from (0, 0) to (N - 1, N - 1) in `mid` amount of time;
                    // try to find a better solution in the next iterations.
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        private void dfs(int[][] grid, int row, int col, int time, boolean[][] visited) {
            int n = grid.length;

            // boundary check
            if (row < 0 || row >= n || col < 0 || col >= n) {
                return;
            }

            if (visited[row][col]) {
                // cell (row, col) is already visited
                return;
            }

            if (grid[row][col] > time) {
                // precondition is not preserved
                return;
            }

            // mark cell (row, col) as visited
            visited[row][col] = true;
            // explore neighbours
            for (int[] d : DIRECTIONS) {
                dfs(grid, row + d[0], col + d[1], time, visited);
            }
        }
    }

    class SwimInRisingWaterDFSWithBinarySearchRev2 implements SwimInRisingWater {

        // up, down, left, right
        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int swimInWater(int[][] grid) {
            final var n = grid.length;

            // binary search the minimum time T to reach (n - 1, n - 1) from (0, 0)
            // FF...FTT...T
            //       ^ answer
            var left = grid[0][0];
            var right = n * n - 1;
            while (left < right) {
                final var mid = left + (right - left) / 2;
                if (dfs(grid, 0, 0, mid, new boolean[n][n])) {
                    // mid may be the answer; check if there's a better
                    // option to the left of mid
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean dfs(int[][] grid, int row, int col, int time, boolean[][] visited) {
            final var n = grid.length;

            visited[row][col] = true;

            // is the target reached?
            if (row == n - 1 && col == n - 1) {
                return true;
            }

            // explore neighbors
            for (var d : DIRS) {
                final var nextRow = row + d[0];
                final var nextCol = col + d[1];
                // out of bounds?
                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                    continue;
                }
                // already visited?
                if (visited[nextRow][nextCol]) {
                    continue;
                }
                // can transition to the next cell?
                if (grid[nextRow][nextCol] > time) {
                    continue;
                }
                // recurse
                if (dfs(grid, nextRow, nextCol, time, visited)) {
                    return true;
                }
            }
            return false;
        }
    }
}
