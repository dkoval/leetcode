package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/">Rotting Oranges</a>
 * <p>
 * You are given an m x n grid where each cell can have one of three values:
 * <ul>
 *  <li>0 representing an empty cell,</li>
 *  <li>1 representing a fresh orange, or</li>
 *  <li>2 representing a rotten orange.</li>
 * </ul>
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 10</li>
 *  <li>grid[i][j] is 0, 1, or 2</li>
 * </ul>
 */
public interface RottingOranges {

    int orangesRotting(int[][] grid);

    class RottingOrangesUsingBFS implements RottingOranges {
        // left, right, up, down
        private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        private static class Cell {
            final int row;
            final int col;

            Cell(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        @Override
        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // collect information about fresh and rotten oranges
            int countFresh = 0;
            Queue<Cell> rotten = new ArrayDeque<>();
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1) {
                        countFresh++;
                    } else if (grid[row][col] == 2) {
                        rotten.offer(new Cell(row, col));
                    }
                }
            }

            // ~ BFS: simulate the process of spreading the infection
            int time = 0;
            while (!rotten.isEmpty()) {
                int size = rotten.size();
                while (size-- > 0) {
                    Cell curr = rotten.poll();
                    // explore 4-directionally adjacent cells
                    for (int[] d : DIRS) {
                        int nextRow = curr.row + d[0];
                        int nextCol = curr.col + d[1];

                        if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1) {
                            grid[nextRow][nextCol] = 2;
                            rotten.offer(new Cell(nextRow, nextCol));
                            countFresh--;
                        }
                    }
                }
                time++;
            }
            return (countFresh == 0) ? Math.max(time - 1, 0) : -1;
        }
    }
}
