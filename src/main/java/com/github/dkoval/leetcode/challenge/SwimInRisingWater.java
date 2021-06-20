package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3785/">Swim in Rising Water</a>
 * <p>
 * On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).
 * <p>
 * Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another
 * 4-directionally adjacent square if and only if the elevation of both squares individually are at most t.
 * You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 * <p>
 * You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= N <= 50.</li>
 *  <li>grid[i][j] is a permutation of [0, ..., N*N - 1].</li>
 * </ul>
 */
public interface SwimInRisingWater {

    int swimInWater(int[][] grid);

    class SwimInRisingWaterDFSWithBinarySearch implements SwimInRisingWater {

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
}
