package com.github.dkoval.leetcode.challenge;

/**
 * <a href = "https://leetcode.com/problems/find-the-largest-area-of-square-inside-two-rectangles/">Find the Largest Area of Square Inside Two Rectangles</a>
 * <p>
 * There exist n rectangles in a 2D plane with edges parallel to the x and y axis. You are given two 2D integer arrays
 * bottomLeft and topRight where bottomLeft[i] = [a_i, b_i] and topRight[i] = [c_i, d_i] represent the bottom-left and top-right
 * coordinates of the ith rectangle, respectively.
 * <p>
 * You need to find the maximum area of a square that can fit inside the intersecting region of at least two rectangles.
 * Return 0 if such a square does not exist.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == bottomLeft.length == topRight.length</li>
 *  <li>2 <= n <= 10^3</li>
 *  <li>bottomLeft[i].length == topRight[i].length == 2</li>
 *  <li>1 <= bottomLeft[i][0], bottomLeft[i][1] <= 10^7</li>
 *  <li>1 <= topRight[i][0], topRight[i][1] <= 10^7</li>
 *  <li>bottomLeft[i][0] < topRight[i][0]</li>
 *  <li>bottomLeft[i][1] < topRight[i][1]</li>
 * </ul>
 */
public interface FindLargestAreaOfSquareInsideTwoRectangles {

    long largestSquareArea(int[][] bottomLeft, int[][] topRight);

    class FindLargestAreaOfSquareInsideTwoRectanglesRev1 implements FindLargestAreaOfSquareInsideTwoRectangles {

        @Override
        public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
            final var n = bottomLeft.length;

            // consider intersections of all possible pairs of rectangles
            var best = 0L;
            for (var i = 0; i < n - 1; i++) {
                for (var j = i + 1; j < n; j++) {
                    best = Math.max(best, calc(
                            new Rectangle(
                                    new Point(bottomLeft[i][0], bottomLeft[i][1]),
                                    new Point(topRight[i][0], topRight[i][1])
                            ),
                            new Rectangle(
                                    new Point(bottomLeft[j][0], bottomLeft[j][1]),
                                    new Point(topRight[j][0], topRight[j][1])
                            )
                    ));
                }
            }
            return best;
        }

        // computes the area of the largest square that can fit inside the intersecting
        // region of two rectangles
        private long calc(Rectangle r1, Rectangle r2) {
            // process each dimension independently: find the length of 2 segments overlap
            final var overlapX = overlap(r1.bl.x, r1.tr.x, r2.bl.x, r2.tr.x);
            final var overlapY = overlap(r1.bl.y, r1.tr.y, r2.bl.y, r2.tr.y);

            final var side = Math.min(overlapX, overlapY);
            return (long) side * side;
        }

        // returns the length of 2 segments overlap
        private int overlap(int start1, int end1, int start2, int end2) {
            // start1 < end1
            // start2 < end2
            final var start = Math.max(start1, start2);
            final var end = Math.min(end1, end2);
            return Math.max(end - start, 0);
        }

        record Point(int x, int y) {
        }

        // top-left and bottom-right corners of a rectangle
        record Rectangle(Point bl, Point tr) {
        }
    }
}
