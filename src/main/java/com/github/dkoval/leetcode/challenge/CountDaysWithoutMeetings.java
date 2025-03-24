package com.github.dkoval.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/count-days-without-meetings/">Count Days Without Meetings</a>
 * <p>
 * You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1).
 * You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).
 * <p>
 * Return the count of days when the employee is available for work but no meetings are scheduled.
 * <p>
 * Note: The meetings may overlap.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= days <= 10^9</a>
 *  <li>1 <= meetings.length <= 10^5</a>
 *  <li>meetings[i].length == 2</a>
 *  <li>1 <= meetings[i][0] <= meetings[i][1] <= days</a>
 * </ul>
 */
public interface CountDaysWithoutMeetings {

    int countDays(int days, int[][] meetings);

    class CountDaysWithoutMeetingsRev1 implements CountDaysWithoutMeetings {

        @Override
        public int countDays(int days, int[][] meetings) {
            final var n = meetings.length;

            // sort the meetings by the starting day
            Arrays.sort(meetings, Comparator.comparingInt(it -> it[0]));

            // merge overlapping meetings
            final var all = new ArrayList<int[]>();
            all.add(meetings[0]);
            for (var i = 1; i < n; i++) {
                var last = all.getLast();
                if (overlap(last, meetings[i])) {
                    last[1] = Math.max(last[1], meetings[i][1]);
                } else {
                    all.add(meetings[i]);
                }
            }

            // count days without meetings
            var count = all.getFirst()[0] - 1;
            for (var i = 1; i < all.size(); i++) {
                // diff between the start time of the current meeting and the end time of the previous meeting
                count += all.get(i)[0] - all.get(i - 1)[1] - 1;
            }
            return count + days - all.getLast()[1];
        }

        private boolean overlap(int[] interval1, int[] interval2) {
            return interval2[1] >= interval1[0] && interval2[0] <= interval1[1];
        }
    }
}
