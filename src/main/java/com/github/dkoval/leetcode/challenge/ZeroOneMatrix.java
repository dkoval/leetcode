package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/01-matrix/">01 Matrix</a>
 * <p>
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == mat.length</li>
 *  <li>n == mat[i].length</li>
 *  <li>1 <= m, n <= 10^4</li>
 *  <li>1 <= m * n <= 10^4</li>
 *  <li>mat[i][j] is either 0 or 1</li>
 *  <li>There is at least one 0 in mat</li>
 * </ul>
 */
public interface ZeroOneMatrix {

    int[][] updateMatrix(int[][] mat);

    class ZeroOneMatrixBFS implements ZeroOneMatrix {

        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        // O(M * N) time | O(M * N) space
        @Override
        public int[][] updateMatrix(int[][] mat) {
            // Idea: run multi BFS from 0's
            int m = mat.length;
            int n = mat[0].length;

            // step #1: collect 0's
            Queue<Cell> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[m][n];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (mat[row][col] == 0) {
                        q.offer(new Cell(row, col, 0));
                        visited[row][col] = true;
                    }
                }
            }

            // step #2: run BFS (BFS guarantees the shortest path from source to destination)
            int[][] ans = new int[m][n];
            while (!q.isEmpty()) {
                Cell curr = q.poll();
                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {
                        continue;
                    }

                    int nextDist = 0;
                    if (mat[nextRow][nextCol] == 1) {
                        nextDist += curr.dist + 1;
                        ans[nextRow][nextCol] = nextDist;
                    }

                    q.offer(new Cell(nextRow, nextCol, nextDist));
                    visited[nextRow][nextCol] = true;
                }
            }
            return ans;
        }

        private static class Cell {
            final int row;
            final int col;
            final int dist; // distance to the nearest 0

            Cell(int row, int col, int dist) {
                this.row = row;
                this.col = col;
                this.dist = dist;
            }
        }
    }

    class ZeroOneMatrixDPBottomUp implements ZeroOneMatrix {

        // derived from the problem's constraints
        private static final int MAX_VALUE = 10_001;

        // O(M * N) time | O(M * N) space
        @Override
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            // dp[i][j] - the shortest distance from (i, j) to 0's cell
            // dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i + 1][j], dp[i][j + 1]), if mat[i][j] = 1
            // dp[i][j] = 0, if mat[i][j] = 0;
            int[][] dp = new int[m][n];

            // phase #1: iterate through matrix top to bottom and left to right to compute
            // dp[i][j] = min(dp[i - 1][j], d[i][j - 1])
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1) {
                        int top = (i > 0) ? dp[i - 1][j] : MAX_VALUE;
                        int left = (j > 0) ? dp[i][j - 1] : MAX_VALUE;
                        dp[i][j] = 1 + Math.min(top, left);
                    }
                }
            }

            // phase #2: iterate through matrix bottom to top and right to left to compute
            // dp[i][j] = min(dp[i][j], dp[i + 1][j], dp[i][j + 1])
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (mat[i][j] == 1) {
                        int bottom = (i + 1 < m) ? dp[i + 1][j] : MAX_VALUE;
                        int right = (j + 1 < n) ? dp[i][j + 1] : MAX_VALUE;
                        dp[i][j] = Math.min(dp[i][j], 1 + Math.min(bottom, right));
                    }
                }
            }
            return dp;
        }
    }
}
