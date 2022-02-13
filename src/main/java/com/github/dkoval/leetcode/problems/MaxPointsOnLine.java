package com.github.dkoval.leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/max-points-on-a-line/">Max Points on a Line (Hard)</a>
 * <p>
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
 * return the maximum number of points that lie on the same straight line.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= points.length <= 300</li>
 *  <li>points[i].length == 2</li>
 *  <li>-10^4 <= xi, yi <= 10^4</li>
 *  <li>All the points are unique</li>
 * </ul>
 */
public class MaxPointsOnLine {

    // O(N^2) time | O(N) space
    public int maxPoints(int[][] points) {
        // Analysis:
        // - any 2 unique points define a line on the XY-plane
        // - any 2 points (x1, y1) and (x2, y2) on the same line share the same tan(alpha) = (y2 - y1) / (x2 - x1)
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // tan(alpha) -> count
            Map<RationalNumber, Integer> counts = new HashMap<>();
            int maxCount = 0;
            for (int j = i + 1; j < n; j++) {
                // dx = 0 denotes a line parallel to Y-axis
                int dx = points[j][0] - points[i][0];
                // dy = 0 denotes a line parallel to X-axis
                int dy = points[j][1] - points[i][1];

                RationalNumber tan = new RationalNumber(dy, dx);
                int count = counts.getOrDefault(tan, 0) + 1;
                counts.put(tan, count);
                maxCount = Math.max(maxCount, count);
            }
            ans = Math.max(ans, maxCount + 1);
        }
        return ans;
    }

    // Rational number is a number of (p / q) form.
    // For this problem, (0, q) and (p, 0) are considered valid.
    private static class RationalNumber {
        final int p;
        final int q;

        RationalNumber(int p, int q) {
            // normalize p and q
            int gcd = gcd(p, q);
            this.p = p / gcd;
            this.q = q / gcd;
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(p, q);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RationalNumber that = (RationalNumber) obj;
            return (p == that.p) && (q == that.q);
        }
    }
}
