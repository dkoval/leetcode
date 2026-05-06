package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/rotating-the-box/">Rotating the Box</a>
 * <p>
 * You are given an m x n matrix of characters box representing a side-view of a box.
 * Each cell of the box is one of the following:
 * <ul>
 *  <li>A stone '#'</li>
 *  <li>A stationary obstacle '*'</li>
 *  <li>Empty '.'</li>
 * </ul>
 * The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity.
 * Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box.
 * Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect
 * the stones' horizontal positions.
 * <p>
 * It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
 * <p>
 * Return an n x m matrix representing the box after the rotation described above.
 * <p>
 * Constraints:
 * <ul>
 *  <li>m == box.length</li>
 *  <li>n == box[i].length</li>
 *  <li>1 <= m, n <= 500</li>
 *  <li>box[i][j] is either '#', '*', or '.'.</li>
 * </ul>
 */
public interface RotatingBox {

    char STONE = '#';
    char OBSTACLE = '*';
    char EMPTY = '.';

    char[][] rotateTheBox(char[][] box);

    class RotatingBoxRev1 implements RotatingBox {

        private static char[][] rotate(char[][] box) {
            int m = box.length;
            int n = box[0].length;

            char[][] ans = new char[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans[j][m - i - 1] = box[i][j];
                }
            }
            return ans;
        }

        @Override
        public char[][] rotateTheBox(char[][] box) {
            char[][] rotatedBox = rotate(box);

            int m = rotatedBox.length;
            int n = rotatedBox[0].length;

            // For each column in the rotated box, let the gravity go its thing.
            for (int j = 0; j < n; j++) {
                int stonePutIndex = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    switch (rotatedBox[i][j]) {
                        case STONE -> {
                            // move the stone to the rightmost empty cell
                            if (i != stonePutIndex) {
                                rotatedBox[i][j] = EMPTY;
                                rotatedBox[stonePutIndex][j] = STONE;
                            }
                            stonePutIndex--;
                        }
                        case OBSTACLE -> stonePutIndex = i - 1;
                    }
                }
            }
            return rotatedBox;
        }
    }

    class RotatingBoxRev2 implements RotatingBox {

        @Override
        public char[][] rotateTheBox(char[][] boxGrid) {
            final var m = boxGrid.length;
            final var n = boxGrid[0].length;

            for (var row = 0; row < m; row++) {
                // for each row, let the gravity do its thing
                var emptyCol = n - 1;
                for (var col = n - 1; col >= 0; col--) {
                    if (boxGrid[row][col] == STONE) {
                        // move the stone to the rightmost empty cell
                        boxGrid[row][col] = EMPTY;
                        boxGrid[row][emptyCol] = STONE;
                        emptyCol--;
                    } else if (boxGrid[row][col] == OBSTACLE) {
                        emptyCol = col - 1;
                    }
                }
            }
            return rotateClockwise(boxGrid);
        }

        private char[][] rotateClockwise(char[][] boxGrid) {
            final var m = boxGrid.length;
            final var n = boxGrid[0].length;

            final var res = new char[n][m];
            for (var row = 0; row < m; row++) {
                for (var col = 0; col < n; col++) {
                    res[col][m - row - 1] = boxGrid[row][col];
                }
            }
            return res;
        }
    }
}
