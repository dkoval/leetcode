package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix-iii/">Spiral Matrix III</a>
 * <p>
 * You start at the cell (rStart, cStart) of an rows x cols grid facing east.
 * The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.
 * <p>
 * You will walk in a clockwise spiral shape to visit every position in this grid.
 * Whenever you move outside the grid's boundary, we continue our walk outside the grid
 * (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.
 * <p>
 * Return an array of coordinates representing the positions of the grid in the order you visited them.
 */
public interface SpiralMatrix3 {

    int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart);

    class SpiralMatrix3Rev1 implements SpiralMatrix3 {
        // right, down, left, up
        private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        @Override
        public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
            int n = rows * cols;
            // spiral pattern in terms of number of steps:
            // 1, 1, 2, 2, 3, 3, 4, 4, ...

            int[][] ans = new int[n][2];
            int index = 0;

            // the current (row, col) coordinates
            int row = rStart;
            int col = cStart;

            // the index in DIRS[] denotes the current direction:
            // 0 - right, 1 - down, 2 - left, 3 - up
            int d = 0;
            // the number of steps to take in the current direction
            int steps = 1;
            while (index < n) {
                // the outer loop simulates the spiral pattern:
                // 1, 1, 2, 2, 3, 3, 4, 4, ...
                int repeat = 2;
                while (repeat-- > 0) {
                    // move the given number of steps in the current direction
                    for (int k = 0; k < steps; k++) {
                        if (row >= 0 && row < rows && col >= 0 && col < cols) {
                            ans[index++] = new int[]{row, col};
                        }
                        // update the (row, col) coordinates
                        row += DIRS[d][0];
                        col += DIRS[d][1];
                    }
                    // change the direction
                    d = (d + 1) % 4;
                }
                steps++;
            }
            return ans;
        }
    }
}
