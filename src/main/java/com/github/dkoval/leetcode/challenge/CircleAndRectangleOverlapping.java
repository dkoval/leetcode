package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/circle-and-rectangle-overlapping/">Circle and Rectangle Overlapping</a>
 * <p>
 * You are given a circle represented as (radius, xCenter, yCenter) and an axis-aligned rectangle represented as
 * (x1, y1, x2, y2), where (x1, y1) are the coordinates of the bottom-left corner, and (x2, y2) are the coordinates of
 * the top-right corner of the rectangle.
 * <p>
 * Return true if the circle and rectangle are overlapped, otherwise return false.
 * In other words, check if there is any point (xi, yi) that belongs to the circle and the rectangle at the same time.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= radius <= 2000</li>
 *  <li>-10^4 <= xCenter, yCenter <= 10^4</li>
 *  <li>-10^4 <= x1 < x2 <= 10^4</li>
 *  <li>-10^4 <= y1 < y2 <= 10^4</li>
 * </ul>
 */
public interface CircleAndRectangleOverlapping {

    boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2);

    class CircleAndRectangleOverlappingRev1 implements CircleAndRectangleOverlapping {

        @Override
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            var closestX = closest(xCenter, x1, x2);
            var closestY = closest(yCenter, y1, y2);
            return distanceSquared(xCenter, yCenter, closestX, closestY) <= radius * radius;
        }

        private int closest(int center, int a, int b) {
            if (a > center) {
                return a;
            } else if (b < center) {
                return b;
            }
            return center;
        }

        private int distanceSquared(int x1, int y1, int x2, int y2) {
            var dx = x2 - x1;
            var dy = y2 - y1;
            return dx * dx + dy * dy;
        }
    }

    class CircleAndRectangleOverlappingRev2 implements CircleAndRectangleOverlapping {

        @Override
        public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
            // find the closest point to the circle within the rectangle
            final var closestX = Math.max(x1, Math.min(xCenter, x2));
            final var closestY = Math.max(y1, Math.min(yCenter, y2));

            // calculate the distance between the circle's center and this closest point
            final var dx = xCenter - closestX;
            final var dy = yCenter - closestY;

            // if the distance is less than the circle's radius, an intersection occurs
            return (dx * dx + dy * dy) <= (radius * radius);
        }
    }
}
