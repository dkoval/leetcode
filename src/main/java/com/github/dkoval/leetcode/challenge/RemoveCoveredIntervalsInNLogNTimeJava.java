package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class RemoveCoveredIntervalsInNLogNTimeJava implements RemoveCoveredIntervals {

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
