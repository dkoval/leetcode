package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/">Reschedule Meetings for Maximum Free Time I</a>
 * <p>
 * You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time t = eventTime.
 * <p>
 * You are also given two integer arrays startTime and endTime, each of length n.
 * These represent the start and end time of n non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].
 * <p>
 * You can reschedule at most k meetings by moving their start time while maintaining the same duration,
 * to maximize the longest continuous period of free time during the event.
 * <p>
 * The relative order of all the meetings should stay the same and they should remain non-overlapping.
 * <p>
 * Return the maximum amount of free time possible after rearranging the meetings.
 * <p>
 * Note that the meetings can not be rescheduled to a time outside the event.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= eventTime <= 10^9</li>
 *  <li>n == startTime.length == endTime.length</li>
 *  <li>2 <= n <= 10^5</li>
 *  <li>1 <= k <= n</li>
 *  <li>0 <= startTime[i] < endTime[i] <= eventTime</li>
 *  <li>endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].</li>
 * </ul>
 */
public interface RescheduleMeetingsForMaximumFreeTime1 {

    int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime);

    class RescheduleMeetingsForMaximumFreeTime1Rev1 implements RescheduleMeetingsForMaximumFreeTime1 {

        @Override
        public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
            final var n = startTime.length;

            var last = 0;
            final var gaps = new ArrayList<Integer>();
            for (var i = 0; i < n; i++) {
                gaps.add(startTime[i] - last);
                last = endTime[i];
            }
            gaps.add(eventTime - endTime[n - 1]);

            // sliding window of size (k + 1)
            var total = 0;
            var best = 0;
            for (var i = 0; i < gaps.size(); i++) {
                if (i >= k + 1) {
                    total -= gaps.get(i - (k + 1));
                }
                total += gaps.get(i);
                best = Math.max(best, total);
            }
            return best;
        }
    }
}
