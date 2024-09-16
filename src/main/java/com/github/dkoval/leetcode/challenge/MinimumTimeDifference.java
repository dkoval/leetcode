package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/minimum-time-difference/">Minimum Time Difference</a>
 * <p>
 * Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
 * <p>
 * Constraints:
 * <ul>
 *  <li>2 <= timePoints.length <= 2 * 10</li>
 *  <li>timePoints[i] is in the format "HH:MM"</li>
 * </ul>
 */
public interface MinimumTimeDifference {

    int findMinDifference(List<String> timePoints);

    // O(N * logN) time | O(N) space
    class MinimumTimeDifferenceRev1 implements MinimumTimeDifference {

        @Override
        public int findMinDifference(List<String> timePoints) {
            int n = timePoints.size();

            int i = 0;
            int[] points = new int[n];
            for (String timePoint : timePoints) {
                points[i++] = getMinutesIn24HourClock(timePoint);
            }

            Arrays.sort(points);

            int best = Integer.MAX_VALUE;
            for (i = 0; i < n; i++) {
                best = Math.min(best, timeDiff(points[i], points[(i + 1) % n]));
            }
            return best;
        }

        private int getMinutesIn24HourClock(String timePoint) {
            // timePoints[i] is in the format "HH:MM"
            String[] tokens = timePoint.split(":");
            int hours = Integer.parseInt(tokens[0]);
            int minutes = Integer.parseInt(tokens[1]);
            return hours * 60 + minutes;
        }

        private int timeDiff(int p1, int p2) {
            int x = Math.min(p1, p2);
            int y = Math.max(p1, p2);
            return Math.min(y - x, 24 * 60 + x - y);
        }
    }
}
