package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/where-will-the-ball-fall/">Where Will the Ball Fall</a>
 * <p>
 * You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
 * <p>
 * Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.
 * <ul>
 *  <li>A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.</li>
 *  <li>A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.</li>
 * </ul>
 * We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom.
 * A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.
 * <p>
 * Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom
 * after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == grid.length</li>
 *  <li>n == grid[i].length</li>
 *  <li>1 <= m, n <= 100</li>
 *  <li>grid[i][j] is 1 or -1</li>
 * </ul>
 */
public interface WhereWillBallFall {

    int[] findBall(int[][] grid);

    // O(M * N) time | O(1) space
    // Resource: https://www.youtube.com/watch?v=HeGDdUvNDNc
    class WhereWillBallFallRev1 implements WhereWillBallFall {

        @Override
        public int[] findBall(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            // balls[i] is the column the i-th balls is currently in
            // initially, each balls is in its own column
            int[] balls = new int[n];
            for (int i = 0; i < n; i++) {
                balls[i] = i;
            }

            // run simulation
            for (int row = 0; row < m; row++) {
                for (int i = 0; i < n; i++) {
                    int col = balls[i];

                    // already stuck?
                    if (col == -1) {
                        continue;
                    }

                    // redirect the i-th balls
                    int nextCol = col + grid[row][col];

                    // falls out of the board or hits a "V" shaped pattern?
                    if (nextCol < 0 || nextCol >= n || grid[row][nextCol] == -grid[row][col]) {
                        balls[i] = -1;
                        continue;
                    }

                    balls[i] = nextCol;
                }
            }
            return balls;
        }
    }
}
