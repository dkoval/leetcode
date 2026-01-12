package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-time-visiting-all-points/">Minimum Time Visiting All Points</a>
 * <p>
 * On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi].
 * Return the minimum time in seconds to visit all the points in the order given by points.
 * <p>
 * You can move according to these rules:
 * <ul>
 *  <li>In 1 second, you can either:
 *      <ul>
 *          <li>move vertically by one unit,</li>
 *          <li>move horizontally by one unit, or</li>
 *          <li>move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).</li>
 *      </ul>
 *  </li>
 *  <li>You have to visit the points in the same order as they appear in the array.</li>
 *  <li>You are allowed to pass through points that appear later in the order, but these do not count as visits.</li>
 * </ul>
 * <p>
 * Constraints:
 * <ul>
 *  <li>points.length == n</li>
 *  <li>1 <= n <= 100</li>
 *  <li>points[i].length == 2</li>
 *  <li>-1000 <= points[i][0], points[i][1] <= 1000</li>
 * </ul>
 */
public interface MinimumTimeVisitingAllPoints {

    int minTimeToVisitAllPoints(int[][] points);

    // O(N) time | O(1) space
    class MinimumTimeVisitingAllPointsRev1 implements MinimumTimeVisitingAllPoints {

        @Override
        public int minTimeToVisitAllPoints(int[][] points) {
            final var n = points.length;

            var total = 0;
            for (int i = 1; i < n; i++) {
                int dx = Math.abs(points[i][0] - points[i - 1][0]);
                int dy = Math.abs(points[i][1] - points[i - 1][1]);
                total += Math.max(dx, dy);
            }
            return total;
        }
    }
}
