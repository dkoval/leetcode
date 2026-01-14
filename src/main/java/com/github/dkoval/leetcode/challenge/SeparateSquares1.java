package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/separate-squares-i/">Separate Squares I</a>
 * <p>
 * You are given a 2D integer array squares. Each squares[i] = [xi, yi, li] represents the coordinates of the bottom-left
 * point and the side length of a square parallel to the x-axis.
 * <p>
 * Find the minimum y-coordinate value of a horizontal line such that the total area of the squares above the line equals
 * the total area of the squares below the line.
 * <p>
 * Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * Note: Squares may overlap. Overlapping areas should be counted multiple times.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= squares.length <= 5 * 10^4</li>
 *  <li>squares[i] = [xi, yi, li]</li>
 *  <li>squares[i].length == 3</li>
 *  <li>0 <= xi, yi <= 10^9</li>
 *  <li>1 <= li <= 10^9</li>
 *  <li>The total area of all the squares will not exceed 10^12.</li>
 * </ul
 */
public interface SeparateSquares1 {

    double EPS = 1e-5;

    double separateSquares(int[][] squares);

    class SeparateSquares1Rev1 implements SeparateSquares1 {

        @Override
        public double separateSquares(int[][] squares) {
            // binary search on y
            var left = 0.0;
            var right = 0.0;

            var totalArea = 0.0;
            for (var square : squares) {
                final var y = (double) square[1];
                final var l = (double) square[2];

                right = Math.max(right, y + l);
                totalArea += l * l;
            }

            while (Math.abs(right - left) > EPS) {
                final var mid = left + (right - left) / 2;
                if (good(squares, totalArea, mid)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }

        private boolean good(int[][] squares, double totalArea, double targetY) {
            var currentArea = 0.0;
            for (var square : squares) {
                final var y = (double) square[1];
                final var l = (double) square[2];

                if (y + l <= targetY) {
                    // targetY is above y + l
                    currentArea += l * l;
                } else if (targetY > y && targetY < y + l) {
                    // targetY is between y and y + l
                    final var belowLength = targetY - y;
                    currentArea += belowLength * l;
                }
            }
            return currentArea * 2 >= totalArea;
        }
    }
}
