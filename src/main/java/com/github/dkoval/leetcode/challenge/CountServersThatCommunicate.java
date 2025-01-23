package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/count-servers-that-communicate/">Count Servers that Communicate</a>
 * <p>
 * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell
 * there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same
 * row or on the same column.
 * <p>
 * Return the number of servers that communicate with any other server.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m <= 250</li>
 *  <li>1 <= n <= 250</li>
 *  <li>grid[i][j] == 0 or 1</li>
 * </ul>
 */
public interface CountServersThatCommunicate {

    int countServers(int[][] grid);

    // O(M * N) time | O(M + N) space
    class CountServersThatCommunicateRev1 implements CountServersThatCommunicate {

        @Override
        public int countServers(int[][] grid) {
            final int m = grid.length;
            final int n = grid[0].length;

            final int[] rows = new int[m];
            final int[] cols = new int[n];

            // precompute the number of servers in each row and column
            for (var i = 0; i < m; i++) {
                for (var j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        rows[i]++;
                        cols[j]++;
                    }
                }
            }

            int total = 0;
            for (var i = 0; i < m; i++) {
                for (var j = 0; j < n; j++) {
                    // if there is more than one server in the same row or column, they communicate
                    if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                        total++;
                    }
                }
            }
            return total;
        }
    }
}
