package com.github.dkoval.leetcode.challenge;

import org.jetbrains.annotations.NotNull;

public class RemoveCoveredIntervalsBruteForceJava implements RemoveCoveredIntervals {

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
