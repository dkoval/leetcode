package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/rectangle-overlap/">Rectangle Overlap</a>
 * <p>
 * An axis-aligned rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) is the coordinate of its bottom-left corner,
 * and (x2, y2) is the coordinate of its top-right corner. Its top and bottom edges are parallel to the X-axis,
 * and its left and right edges are parallel to the Y-axis.
 * <p>
 * Two rectangles overlap if the area of their intersection is positive.
 * To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * <p>
 * Given two axis-aligned rectangles rec1 and rec2, return true if they overlap, otherwise return false.
 * <p>
 * Constraints:
 * <ul>
 *  <li>rec1.length == 4</li>
 *  <li>rec2.length == 4</li>
 *  <li>-109 <= rec1[i], rec2[i] <= 10^9</li>
 *  <li>rec1 and rec2 represent a valid rectangle with a non-zero area.</li>
 * </ul>
 */
public interface RectangleOverlap {

    boolean isRectangleOverlap(int[] rec1, int[] rec2);

    class RectangleOverlapRev1 implements RectangleOverlap {

        @Override
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            final var x1 = new Interval(rec1[0], rec1[2]);
            final var x2 = new Interval(rec2[0], rec2[2]);

            final var y1 = new Interval(rec1[1], rec1[3]);
            final var y2 = new Interval(rec2[1], rec2[3]);

            return x1.overlap(x2) && y1.overlap(y2);
        }

        private record Interval(int start, int end) {

            public boolean overlap(Interval that) {
                return !doesNotOverlap(that);
            }

            public boolean doesNotOverlap(Interval that) {
                return (that.end <= start) || (that.start >= end);
            }
        }
    }
}
