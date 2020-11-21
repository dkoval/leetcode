package com.github.dkoval.leetcode.mock;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/minimum-area-rectangle/">Minimum Area Rectangle</a>
 * <p>
 * Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points,
 * with sides parallel to the x and y axes.
 * <p>
 * If there isn't any rectangle, return 0.
 */
public class MinimumAreaRectangle {

    public int minAreaRect(int[][] points) {
        Set<Point> allPoints = points(points);
        int minArea = Integer.MAX_VALUE;
        // generate all possible (x_i, y_i), (x_j, y_j) pairs of points
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1]; // top-left point
                int x2 = points[j][0], y2 = points[j][1]; // bottom-right point
                // ignore pairs of points that form horizontal or vertical lines (degenerated rectangles)
                if (x1 != x2 && y1 != y2) {
                    // check if top-right & bottom-left points are on the XY-plane
                    if (!allPoints.contains(new Point(x2, y1)) || !allPoints.contains(new Point(x1, y2))) {
                        continue;
                    }
                    int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                    minArea = Math.min(minArea, area);
                }
            }
        }
        return (minArea == Integer.MAX_VALUE) ? 0 : minArea;
    }

    private Set<Point> points(int[][] points) {
        Set<Point> result = new HashSet<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            result.add(new Point(x, y));
        }
        return result;
    }

    private static final class Point {
        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object that) {
            if (this == that) return true;
            if (!(that instanceof Point)) return false;
            Point other = (Point) that;
            return Objects.equals(x, other.x) && Objects.equals(y, other.y);
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
