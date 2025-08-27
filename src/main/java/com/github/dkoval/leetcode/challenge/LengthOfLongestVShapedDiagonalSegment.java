package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/">Length of Longest V-Shaped Diagonal Segment</a>
 * <p>
 * You are given a 2D integer matrix grid of size n x m, where each element is either 0, 1, or 2.
 * <p>
 * A V-shaped diagonal segment is defined as:
 * <p>
 * The segment starts with 1.
 * <p>
 * The subsequent elements follow this infinite sequence: 2, 0, 2, 0, ....
 * <p>
 * The segment:
 * <p>
 * Starts along a diagonal direction (top-left to bottom-right, bottom-right to top-left, top-right to bottom-left, or bottom-left to top-right).
 * <p>
 * Continues the sequence in the same diagonal direction.
 * <p>
 * Makes at most one clockwise 90-degree turn to another diagonal direction while maintaining the sequence.
 * <p>
 * Return the length of the longest V-shaped diagonal segment. If no valid segment exists, return 0.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == grid.length</li>
 *  <li>m == grid[i].length</li>
 *  <li>1 <= n, m <= 500</li>
 *  <li>grid[i][j] is either 0, 1 or 2.</li>
 * </ul>
 */
public interface LengthOfLongestVShapedDiagonalSegment {

    int lenOfVDiagonal(int[][] grid);

    class LengthOfLongestVShapedDiagonalSegmentRev1 implements LengthOfLongestVShapedDiagonalSegment {

        // 4 diagonal directions (clockwise)
        private static final int[][] DIRS = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

        @Override
        public int lenOfVDiagonal(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // idea: DP
            // M * N * (turned right - Y/N) * (4 diagonal directions)
            final var dp = new Integer[m][n][2][4];

            var best = 0;
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        // start a V-shaped segment
                        best = Math.max(best, 1);
                        for (var dIdx = 0; dIdx < 4; dIdx++) {
                            final var d = DIRS[dIdx];
                            final var next = new Cell(row + d[0], col + d[1]);
                            if (next.isWithinGrid(m, n) && grid[next.row][next.col] == 2) {
                                // 1, 2, ...
                                best = Math.max(best, 2 + calc(grid, next, false, dIdx, dp));
                            }
                        }
                    }
                }
            }
            return best;
        }

        private int calc(int[][] grid, Cell curr, boolean turnedRight, int dIdx, Integer[][][][] dp) {
            int m = grid.length;
            int n = grid[0].length;

            // already solved?
            final var turn = turnedRight ? 1 : 0;
            if (dp[curr.row][curr.col][turn][dIdx] != null) {
                return dp[curr.row][curr.col][turn][dIdx];
            }

            // sequence: 2, 0, 2, 0, ...
            var best = 0;

            // option 1: keep going straight
            var d = DIRS[dIdx];
            var next = curr.move(d[0], d[1]);
            if (next.isWithinGrid(m, n) && grid[curr.row][curr.col] + grid[next.row][next.col] == 2) {
                best = Math.max(best, 1 + calc(grid, next, turnedRight, dIdx, dp));
            }

            // option 2: turn right, if possible
            if (!turnedRight) {
                d = DIRS[(dIdx + 1) % 4];
                next = curr.move(d[0], d[1]);
                if (next.isWithinGrid(m, n) && grid[curr.row][curr.col] + grid[next.row][next.col] == 2) {
                    best = Math.max(best, 1 + calc(grid, next, true, (dIdx + 1) % 4, dp));
                }
            }

            // cache and return the answer
            return dp[curr.row][curr.col][turn][dIdx] = best;
        }

        private record Cell(int row, int col) {

            Cell move(int dr, int dc) {
                return new Cell(row + dr, col + dc);
            }

            boolean isWithinGrid(int m, int n) {
                return row >= 0 && row < m && col >= 0 && col < n;
            }
        }
    }
}
