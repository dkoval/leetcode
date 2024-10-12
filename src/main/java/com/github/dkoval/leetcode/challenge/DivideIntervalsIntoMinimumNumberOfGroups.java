package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/">Divide Intervals Into Minimum Number of Groups</a>
 * <p>
 * You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].
 * <p>
 * You have to divide the intervals into one or more groups such that each interval is in exactly one group,
 * and no two intervals that are in the same group intersect each other.
 * <p>
 * Return the minimum number of groups you need to make.
 * <p>
 * Two intervals intersect if there is at least one common number between them.
 * For example, the intervals [1, 5] and [5, 8] intersect.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= intervals.length <= 10^5</li>
 *  <li>intervals[i].length == 2</li>
 *  <li>1 <= lefti <= righti <= 10^6</li>
 * </ul>
 */
public interface DivideIntervalsIntoMinimumNumberOfGroups {

    int minGroups(int[][] intervals);

    // Resource: https://algo.monster/liteproblems/2406
    class DivideIntervalsIntoMinimumNumberOfGroupsRev1 implements DivideIntervalsIntoMinimumNumberOfGroups {

        @Override
        public int minGroups(int[][] intervals) {
            // sort intervals by the starting point
            Arrays.sort(intervals, Comparator.comparingInt(it -> it[0]));

            // min-heap keeps track of the end times of the last interval in each group
            Queue<Integer> endTimes = new PriorityQueue<>();

            int groups = 0;
            for (int[] interval : intervals) {
                if (!endTimes.isEmpty() && endTimes.peek() < interval[0]) {
                    // The current interval's starting time is greater than the earliest end time,
                    // meaning there's no overlap with other intervals in the existing group,
                    // therefore we can add the current interval to that group.
                    // Replace the old end time with the end time of the current interval.
                    endTimes.poll();
                } else {
                    // The current interval overlaps with all existing groups,
                    // hence we need to start a new group.
                    groups++;
                }
                endTimes.offer(interval[1]);
            }
            return groups;
        }
    }
}
