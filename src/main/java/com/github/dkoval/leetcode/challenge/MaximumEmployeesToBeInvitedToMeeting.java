package com.github.dkoval.leetcode.challenge;

import java.util.ArrayDeque;

/**
 * <a href="https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/">Maximum Employees to Be Invited to a Meeting (Hard)</a>
 * <p>
 * A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large
 * circular table, capable of seating any number of employees.
 * <p>
 * The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only
 * if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.
 * <p>
 * Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee,
 * return the maximum number of employees that can be invited to the meeting.
 * <p>
 * Constraints:
 * <ul>
 *  <li>n == favorite.length</li>
 *  <li>2 <= n <= 10^5</li>
 *  <li>0 <= favorite[i] <= n - 1</li>
 *  <li>favorite[i] != i</li>
 * </ul>
 */
public interface MaximumEmployeesToBeInvitedToMeeting {

    int maximumInvitations(int[] favorite);

    // Resource: https://youtu.be/-nzvII5tbfc?si=LMTrthdcM5t1BolH
    class MaximumEmployeesToBeInvitedToMeetingRev1 implements MaximumEmployeesToBeInvitedToMeeting {

        @Override
        public int maximumInvitations(int[] favorite) {
            final var n = favorite.length;

            // in-degree of the i-th node
            final var indegree = new int[n];
            for (var i = 0; i < n; i++) {
                indegree[favorite[i]]++;
            }

            // eliminate "extensions" of cycles
            final var q = new ArrayDeque<Integer>();
            for (var i = 0; i < n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            // length[i] - the length of the longest path that ends at the i-th node
            final var length = new int[n];
            while (!q.isEmpty()) {
                var curr = q.poll();
                var next = favorite[curr];
                // take the longest "extension" that lead to `next`
                length[next] = Math.max(length[next], length[curr] + 1);
                if (--indegree[next] == 0) {
                    q.offer(next);
                }
            }

            // at this stage, there're only cycles in the directed graph
            var longestCycle = 0;
            var length2Cycles = 0;
            for (var i = 0; i < n; i++) {
                if (indegree[i] == 0) {
                    // already processed
                    continue;
                }

                var cycleLength = 0;
                var curr = i;
                while (indegree[curr] != 0) {
                    indegree[curr] = 0;
                    curr = favorite[curr];
                    cycleLength++;
                }

                if (cycleLength == 2) {
                    length2Cycles += length[i] + length[favorite[i]] + 2;
                } else {
                    longestCycle = Math.max(longestCycle, cycleLength);
                }
            }
            return Math.max(longestCycle, length2Cycles);
        }
    }
}
