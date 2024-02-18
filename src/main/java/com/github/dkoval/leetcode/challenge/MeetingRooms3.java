package com.github.dkoval.leetcode.challenge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
            // sort meetings by their start time
            Arrays.sort(meetings, Comparator.comparingInt(it -> it[0]));

            Queue<Integer> availableRooms = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                availableRooms.offer(i);
            }

            Queue<Room> bookedRooms = new PriorityQueue<>((room1, room2) ->
                    room1.availableAt == room2.availableAt
                            ? Integer.compare(room1.id, room2.id)
                            : Long.compare(room1.availableAt, room2.availableAt)
            );

            int[] counts = new int[n];
            for (int[] meeting : meetings) {
                // do we have any available rooms at the time i-th meeting starts?
                while (!bookedRooms.isEmpty() && bookedRooms.peek().availableAt <= meeting[0]) {
                    Room room = bookedRooms.poll();
                    availableRooms.offer(room.id);
                }

                if (!availableRooms.isEmpty()) {
                    int room = availableRooms.poll();
                    bookedRooms.offer(new Room(room, meeting[1]));
                    counts[room]++;
                } else {
                    // there are no rooms available, delay the meeting
                    Room room = bookedRooms.poll();
                    room.availableAt += meeting[1] - meeting[0];
                    bookedRooms.offer(room);
                    counts[room.id]++;
                }
            }

            int mostBookedRoom = 0;
            for (int i = 0; i < n; i++) {
                if (counts[i] > counts[mostBookedRoom]) {
                    mostBookedRoom = i;
                }
            }
            return mostBookedRoom;
        }

        private static class Room {
            final int id;
            long availableAt;

            Room(int id, long availableAt) {
                this.id = id;
                this.availableAt = availableAt;
            }
        }
    }
}
