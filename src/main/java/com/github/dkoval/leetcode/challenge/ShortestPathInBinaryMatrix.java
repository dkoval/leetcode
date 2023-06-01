package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/">Shortest Path in Binary Matrix</a>
 * <p>
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * <p>
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 * <ul>
 *  <li>Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)</li>
 *  <li>C_1 is at location (0, 0) (ie. has value grid[0][0])</li>
 *  <li>C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])</li>
 *  <li>If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).</li>
 * </ul>
 * Return the length of the shortest such clear path from top-left to bottom-right. If such a path does not exist, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= n <= 100</li>
 *  <li>grid[i][j] is 0 or 1</li>
 * </ul>
 */
public interface ShortestPathInBinaryMatrix {

    int shortestPathBinaryMatrix(int[][] grid);

    // O(N^2) time | O(N^2) space
    class ShortestPathInBinaryMatrixRev1 implements ShortestPathInBinaryMatrix {

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;

            if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
                // there's no clear path at all
                return -1;
            }

            if (n == 1) {
                return 1;
            }

            // BFS
            Queue<Cell> queue = new ArrayDeque<>();
            enqueue(queue, grid, 0, 0, 1);
            while (!queue.isEmpty()) {
                Cell curr = queue.poll();

                // explore 8-directionally adjacent cells
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nextRow = curr.row + dr;
                        int nextCol = curr.col + dc;

                        if (nextRow == n - 1 && nextCol == n - 1) {
                            return curr.dist + 1;
                        }

                        enqueue(queue, grid, nextRow, nextCol, curr.dist + 1);
                    }
                }
            }
            return -1;
        }

        private void enqueue(Queue<Cell> queue, int[][] grid, int row, int col, int distance) {
            int n = grid.length;
            if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0) {
                grid[row][col] = -1; // mark current cell as visited
                queue.offer(new Cell(row, col, distance));
            }
        }

        private static class Cell {
            final int row;
            final int col;
            final int dist;

            private Cell(int row, int col, int dist) {
                this.row = row;
                this.col = col;
                this.dist = dist;
            }
        }
    }

    // O(N^2) time | O(N^2) space
    class ShortestPathInBinaryMatrixRev2 implements ShortestPathInBinaryMatrix {

        @Override
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
                return -1;
            }

            if (n == 1) {
                return 1;
            }

            // BFS
            int dist = 1;
            Queue<Cell> q = new ArrayDeque<>();
            q.offer(new Cell(0, 0));
            grid[0][0] = -1;
            while (!q.isEmpty()) {
                // process all cells at the current level
                int size = q.size();
                while (size-- > 0) {
                    Cell curr = q.poll();
                    // 8-directionally connected neighbors
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int nextRow = curr.row + dx;
                            int nextCol = curr.col + dy;

                            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n) {
                                continue;
                            }

                            if (grid[nextRow][nextCol] != 0) {
                                continue;
                            }

                            if (nextRow == n - 1 && nextCol == n - 1) {
                                return dist + 1;
                            }

                            q.offer(new Cell(nextRow, nextCol));
                            grid[nextRow][nextCol] = -1;
                        }
                    }
                }
                dist++;
            }
            return -1;
        }

        private static class Cell {
            final int row;
            final int col;

            Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
    }
}
