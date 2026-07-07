package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/remove-covered-intervals/">Remove Covered Intervals</a>
 * <p>
 * Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri),
 * remove all intervals that are covered by another interval in the list.
 * <p>
 * The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
 * <p>
 * Return the number of remaining intervals.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= intervals.length <= 1000</li>
 *  <li>intervals[i].length == 2</li>
 *  <li>0 <= li < ri <= 105</li>
 *  <li>All the given intervals are unique.</li>
 * </ul>
 */
public interface RemoveCoveredIntervals {

    int removeCoveredIntervals(int[][] intervals);

    class RemoveCoveredIntervalsBruteForceJava implements RemoveCoveredIntervals {

        @Override
        public int removeCoveredIntervals(@NotNull int[][] intervals) {
            int numCoveredIntervals = 0;
            for (int i = 0; i < intervals.length; i++) {
                for (int j = 0; j < intervals.length; j++) {
                    if (i == j) continue;
                    if (isIntervalCoveredByAnother(intervals[i], intervals[j])) {
                        numCoveredIntervals++;
                        break;
                    }
                }
            }
            return intervals.length - numCoveredIntervals;
        }

        private boolean isIntervalCoveredByAnother(int[] interval, int[] another) {
            return another[0] <= interval[0] && another[1] >= interval[1];
        }
    }

    class RemoveCoveredIntervalsInNLogNTimeJava implements RemoveCoveredIntervals {

        @Override
        public int removeCoveredIntervals(@NotNull int[][] intervals) {
            Arrays.sort(intervals, (interval1, interval2) ->
                    interval1[0] == interval2[0] ? interval2[1] - interval1[1] : interval1[0] - interval2[0]);
            int numCoveredIntervals = 0;
            int[] prevInterval = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (prevInterval[1] >= intervals[i][1]) {
                    numCoveredIntervals++;
                } else {
                    prevInterval = intervals[i];
                }
            }
            return intervals.length - numCoveredIntervals;
        }
    }

    class RemoveCoveredIntervalsRev2 implements RemoveCoveredIntervals {

        @Override
        public int removeCoveredIntervals(int[][] intervals) {
            final var n = intervals.length;

            Arrays.sort(intervals, (a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : -Integer.compare(a[1], b[1]));

            var count = 0;
            var prev = 0;
            for (var curr = 1; curr < n; curr++) {
                if (isCovered(intervals[prev], intervals[curr])) {
                    count++;
                } else {
                    prev = curr;
                }
            }
            return n - count;
        }

        private boolean isCovered(int[] a, int[] b) {
            return (b[0] >= a[0]) && (b[1] <= a[1]);
        }
    }
}
