package com.github.dkoval.leetcode.challenge;

/**
 * <a href="https://leetcode.com/problems/minimum-score-triangulation-of-polygon/">Minimum Score Triangulation of Polygon</a>
 * <p>
 * You have a convex n-sided polygon where each vertex has an integer value. You are given an integer array values where
 * values[i] is the value of the ith vertex in clockwise order.
 * <p>
 * Polygon triangulation is a process where you divide a polygon into a set of triangles and the vertices of each triangle
 * must also be vertices of the original polygon. Note that no other shapes other than triangles are allowed in the division.
 * This process will result in n - 2 triangles.
 * <p>
 * You will triangulate the polygon. For each triangle, the weight of that triangle is the product of the values at its vertices.
 * The total score of the triangulation is the sum of these weights over all n - 2 triangles.
 * <p>
 * Return the minimum possible score that you can achieve with some triangulation of the polygon.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == values.length</li>
 *  <li>3 <= n <= 50</li>
 *  <li>1 <= values[i] <= 100</li>
 * </ul>
 */
public interface MinimumScoreTriangulationOfPolygon {

    int minScoreTriangulation(int[] values);

    class MinimumScoreTriangulationOfPolygonRev1 implements MinimumScoreTriangulationOfPolygon {

        @Override
        public int minScoreTriangulation(int[] values) {
            final var n = values.length;
            return solve(values, 0, n - 1, new Integer[n][n]);
        }

        private int solve(int[] values, int left, int right, Integer[][] dp) {
            final var points = right - left + 1;
            if (points < 3) {
                return 0;
            }

            if (points == 3) {
                return values[left] * values[left + 1] * values[left + 2];
            }

            // already solved?
            if (dp[left][right] != null) {
                return dp[left][right];
            }

            var best = Integer.MAX_VALUE;
            // choose the 3rd point to draw a triangle
            for (var mid = left + 1; mid < right; mid++) {
                // current triangle: (left, mid, right)
                var curr = values[left] * values[mid] * values[right];
                // polygon #1
                curr += solve(values, left, mid, dp);
                // polygon #2
                curr += solve(values, mid, right, dp);
                best = Math.min(best, curr);
            }
            return dp[left][right] = best;
        }

    }
}
