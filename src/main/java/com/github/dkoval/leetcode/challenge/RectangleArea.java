package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/rectangle-area/">Rectangle Area</a>
 * <p>
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
 * <p>
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 * <p>
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 * <p>
 * Constraints:
 * <ul>
 *  <li>-10^4 <= ax1 <= ax2 <= 10^4</li>
 *  <li>-10^4 <= ay1 <= ay2 <= 10^4</li>
 *  <li>-10^4 <= bx1 <= bx2 <= 10^4</li>
 *  <li>-10^4 <= by1 <= by2 <= 10^4</li>
 * </ul>
 */
public interface RectangleArea {

    int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2);

    class RectangleAreaRev1 implements RectangleArea {

        @Override
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            // inclusion/exclusion principle
            return rectangleArea(ax1, ay1, ax2, ay2)
                    + rectangleArea(bx1, by1, bx2, by2)
                    - overlappingArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        }

        private int rectangleArea(int x1, int y1, int x2, int y2) {
            int width = Math.abs(x2 - x1);
            int height = Math.abs(y2 - y1);
            return width * height;
        }

        private int overlappingArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            // Ox - no overlap?
            if (bx2 < ax1 || bx1 > ax2) {
                return 0;
            }

            // Oy - no overlap?
            if (by2 < ay1 || by1 > ay2) {
                return 0;
            }

            // compute overlapping area
            int width = Math.min(ax2, bx2) - Math.max(ax1, bx1);
            int height = Math.min(ay2, by2) - Math.max(ay1, by1);
            return width * height;
        }
    }
}
