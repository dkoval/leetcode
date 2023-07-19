package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/non-overlapping-intervals/">Non-overlapping Intervals</a>
 * <p>
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
 * you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= intervals.length <= 10^5</li>
 *  <li>intervals[i].length == 2</li>
 *  <li>-5 * 10^4 <= starti < endi <= 5 * 10^4</li>
 * </ul>
 */
public interface NonOverlappingIntervals {

    int eraseOverlapIntervals(int[][] intervals);

    // O(N*logN) time | O(1) space
    class NonOverlappingIntervalsRev1 implements NonOverlappingIntervals {

        @Override
        public int eraseOverlapIntervals(int[][] intervals) {
            int n = intervals.length;

            // sort intervals by their start point
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

            int count = 0;
            int end = intervals[0][1]; // the ending position of the last interval
            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= end) {
                    // no overlap
                    end = intervals[i][1];
                } else {
                    // overlap
                    count++;
                    // remove a larger interval
                    end = Math.min(end, intervals[i][1]);
                }
            }
            return count;
        }
    }
}
