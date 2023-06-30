package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/last-day-where-you-can-still-cross/">Last Day Where You Can Still Cross</a>
 * <p>
 * There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col
 * representing the number of rows and columns in the matrix, respectively.
 * <p>
 * Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water.
 * You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell
 * on the ri-th row and ci-th column (1-based coordinates) will be covered with water (i.e., changed to 1).
 * <p>
 * You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells.
 * You can start from any cell in the top row and end at any cell in the bottom row.
 * You can only travel in the four cardinal directions (left, right, up, and down).
 * <p>
 * Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
 */
public interface LastDayWhereYouCanStillCross {

    int latestDayToCross(int row, int col, int[][] cells);

    class LastDayWhereYouCanStillCrossRev1 implements LastDayWhereYouCanStillCross {

        private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        @Override
        public int latestDayToCross(int row, int col, int[][] cells) {
            // Q: Is it possible to walk from top to the bottom on the i-th day?
            // TTT...T|FFF...F
            //       ^ answer (upper boundary)
            // Idea: binary search
            int left = 0;
            int right = row * col;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (good(row, col, cells, mid)) {
                    // mid might be the answer;
                    // check if there's a better option to the right of it
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private boolean good(int row, int col, int[][] cells, int day) {
            int[][] grid = new int[row + 1][col + 1];
            for (int d = 0; d < day; d++) {
                int r = cells[d][0];
                int c = cells[d][1];
                grid[r][c] = 1;
            }

            // multi-source BFS
            Queue<Cell> q = new ArrayDeque<>();
            for (int c = 1; c <= col; c++) {
                if (grid[1][c] == 0) {
                    q.offer(new Cell(1, c));
                    grid[1][c] = 2; // mark as visited
                }
            }

            while (!q.isEmpty()) {
                Cell curr = q.poll();
                for (int[] d : DIRS) {
                    int nextRow = curr.row + d[0];
                    int nextCol = curr.col + d[1];

                    if (nextRow < 1 || nextRow > row || nextCol < 1 || nextCol > col) {
                        continue;
                    }

                    if (grid[nextRow][nextCol] != 0) {
                        continue;
                    }

                    if (nextRow == row) {
                        return true;
                    }

                    q.offer(new Cell(nextRow, nextCol));
                    grid[nextRow][nextCol] = 2;
                }
            }
            return false;
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
