package com.github.dkoval.leetcode.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/">Merge Intervals</a>
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int[] lastMergedInterval = merged.isEmpty() ? null : merged.get(merged.size() - 1);
            if (lastMergedInterval == null || interval[0] > lastMergedInterval[1]) {
                merged.add(interval);
            } else {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
