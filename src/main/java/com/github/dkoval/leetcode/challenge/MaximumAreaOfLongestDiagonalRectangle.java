package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/">Maximum Area of Longest Diagonal Rectangle</a>
 * <p>
 * You are given a 2D 0-indexed integer array dimensions.
 * <p>
 * For all indices i, 0 <= i < dimensions.length, dimensions[i][0] represents the length and dimensions[i][1] represents
 * the width of the rectangle i.
 * <p>
 * Return the area of the rectangle having the longest diagonal. If there are multiple rectangles with the longest diagonal,
 * return the area of the rectangle having the maximum area.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= dimensions.length <= 100</li>
 *  <li>dimensions[i].length == 2</li>
 *  <li>1 <= dimensions[i][0], dimensions[i][1] <= 100</li>
 * </ul>
 */
public interface MaximumAreaOfLongestDiagonalRectangle {

    int areaOfMaxDiagonal(int[][] dimensions);

    class MaximumAreaOfLongestDiagonalRectangleRev1 implements MaximumAreaOfLongestDiagonalRectangle {

        @Override
        public int areaOfMaxDiagonal(int[][] dimensions) {
            var bestArea = 0;
            var bestDiag = 0;
            for (var rect : dimensions) {
                final var currDiag = rect[0] * rect[0] + rect[1] * rect[1];
                if (currDiag < bestDiag) {
                    continue;
                }

                final var currArea = rect[0] * rect[1];
                if (currDiag > bestDiag) {
                    bestDiag = currDiag;
                    bestArea = currArea;
                } else {
                    bestArea = Math.max(bestArea, currArea);
                }
            }
            return bestArea;
        }
    }
}
