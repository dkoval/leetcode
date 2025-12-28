package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/meeting-rooms-iii/">Meeting Rooms III (Hard)</a>
 * <p>
 * You are given an integer n. There are n rooms numbered from 0 to n - 1.
 * <p>
 * You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during
 * the half-closed time interval [starti, endi). All the values of starti are unique.
 * <p>
 * Meetings are allocated to rooms in the following manner:
 * <ol>
 *  <li>Each meeting will take place in the unused room with the lowest number.</li>
 *  <li>If there are no available rooms, the meeting will be delayed until a room becomes free.
 *  The delayed meeting should have the same duration as the original meeting.
 *  </li>
 *  <li>When a room becomes unused, meetings that have an earlier original start time should be given the room.</li>
 * </ol>
 * Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.
 * <p>
 * A half-closed interval [a, b) is the interval between a and b including a and not including b.
 * <p>
 * Constraints:
 * <ul>
 *  <li>1 <= n <= 100</li>
 *  <li>1 <= meetings.length <= 10^5</li>
 *  <li>meetings[i].length == 2</li>
 *  <li>0 <= starti < endi <= 5 * 10^5</li>
 *  <li>All the values of starti are unique</li>
 * </ul>
 */
public interface MeetingRooms3 {

    int mostBooked(int n, int[][] meetings);

    class MeetingRooms3Rev1 implements MeetingRooms3 {

        @Override
        public int mostBooked(int n, int[][] meetings) {
            // sort meetings by the start time
            Arrays.sort(meetings, Comparator.comparingInt(it -> it[0]));

            final var available = new PriorityQueue<Integer>();
            for (var i = 0; i < n; i++) {
                available.offer(i);
            }

            final var used = new PriorityQueue<MeetingRoom>(
                    (a, b) -> a.availableAt != b.availableAt ? Long.compare(a.availableAt, b.availableAt) : Integer.compare(a.room, b.room)
            );

            // counts[i] - how many times the i-th room got booked
            final var counts = new int[n];
            for (var meeting : meetings) {
                final var start = meeting[0];
                final var end = meeting[1];
                final var duration = end - start;

                // finish the past meetings and make rooms available again
                while (!used.isEmpty() && used.peek().availableAt <= start) {
                    final var curr = used.poll();
                    available.offer(curr.room);
                }

                if (!available.isEmpty()) {
                    final var room = available.poll();
                    used.offer(new MeetingRoom(end, room));
                    counts[room]++;
                } else {
                    // delay the meeting until a room becomes available
                    final var curr = used.poll();
                    used.offer(new MeetingRoom(curr.availableAt + duration, curr.room));
                    counts[curr.room]++;
                }
            }

            var bestRoom = 0;
            for (var i = 1; i < n; i++) {
                if (counts[bestRoom] < counts[i]) {
                    bestRoom = i;
                }
            }
            return bestRoom;
        }

        record MeetingRoom(long availableAt, int room) {
        }
    }
}
