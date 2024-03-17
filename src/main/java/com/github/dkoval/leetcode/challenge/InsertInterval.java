package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/insert-interval/">Insert Interval</a>
 * <p>
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent
 * the start and the end of the ith curr and intervals is sorted in ascending order by starti.
 * You are also given an curr newInterval = [start, end] that represents the start and end of another curr.
 * <p>
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
 * still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * <p>
 * Return intervals after the insertion.
 * <p>
 * Constraints:
 * <ul>
 *  <li>0 <= intervals.length <= 10^4</li>
 *  <li>intervals[i].length == 2</li>
 *  <li>0 <= starti <= endi <= 10^5</li>
 *  <li>intervals is sorted by starti in ascending order.</li>
 *  <li>newInterval.length == 2</li>
 *  <li>0 <= start <= end <= 10^5</li>
 * </ul>
 */
public interface InsertInterval {

    int[][] insert(int[][] intervals, int[] newInterval);

    // O(N) time | O(1) time
    class InsertIntervalRev1 implements InsertInterval {

        @Override
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int n = intervals.length;
            List<int[]> ans = new ArrayList<>();

            boolean inserted = false;
            for (int[] currInterval : intervals) {
                if (newInterval[1] >= currInterval[0] && newInterval[0] <= currInterval[1]) {
                    // overlap
                    if (!inserted) {
                        ans.add(newInterval);
                        inserted = true;
                    }
                    int[] lastInterval = ans.get(ans.size() - 1);
                    lastInterval[0] = Math.min(lastInterval[0], currInterval[0]);
                    lastInterval[1] = Math.max(lastInterval[1], currInterval[1]);
                } else {
                    // no overlap
                    if (!inserted && newInterval[1] < currInterval[0]) {
                        // new interval is before the current one
                        ans.add(newInterval);
                        inserted = true;
                    }
                    ans.add(currInterval);
                }
            }

            if (!inserted) {
                ans.add(newInterval);
            }

            return ans.toArray(int[][]::new);
        }
    }

    // O(N) time | O(1) time
    class InsertIntervalRev3 implements InsertInterval {

        @Override
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int n = intervals.length;
            if (n == 0) {
                return new int[][]{newInterval};
            }

            List<int[]> ans = new ArrayList<>();
            boolean inserted = false;
            for (int[] currInterval : intervals) {
                if (newInterval[1] < currInterval[0] || newInterval[0] > currInterval[1]) {
                    // case #1: no overlap
                    //
                    // Does the new interval come BEFORE the current one?
                    //
                    // Ignore the case where the new interval comes AFTER the current one as the new interval
                    // may potentially overlap with the existing intervals from range [i + 1 : n - 1].
                    // The "Overlap" case is handled separately.
                    //
                    // ................, [new interval], [curr Interval], ...
                    // <-- processed -->                  ^
                    if (!inserted && newInterval[1] < currInterval[0]) {
                        ans.add(newInterval);
                        inserted = true;
                    }
                    ans.add(currInterval);
                } else {
                    // case #2: overlap
                    if (!inserted) {
                        int[] overlap = {
                                Math.min(currInterval[0], newInterval[0]),
                                Math.max(currInterval[1], newInterval[1])
                        };
                        ans.add(overlap);
                        inserted = true;
                    } else {
                        int[] lastInterval = ans.get(ans.size() - 1);
                        lastInterval[1] = Math.max(lastInterval[1], currInterval[1]);
                    }
                }
            }

            // corner case: append the new interval
            if (!inserted) {
                ans.add(newInterval);
            }

            return ans.toArray(int[][]::new);
        }
    }

    // O(N) time | O(1) time
    class InsertIntervalRev4 implements InsertInterval {

        @Override
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int n = intervals.length;

            List<int[]> ans = new ArrayList<>();
            // denotes the interval to be compared with the current i-th interval
            int[] last = newInterval;
            for (int[] curr : intervals) {
                if (last[0] > curr[1]) {
                    // case #1: `last` comes AFTER the current one
                    ans.add(curr);
                } else if (last[1] < curr[0]) {
                    // case #2: `last` comes BEFORE the current one
                    ans.add(last);
                    last = curr;
                } else {
                    // case #3: new curr overlaps with the current one
                    last = new int[]{Math.min(last[0], curr[0]), Math.max(last[1], curr[1])};
                }
            }

            ans.add(last);
            return ans.toArray(int[][]::new);
        }
    }
}
